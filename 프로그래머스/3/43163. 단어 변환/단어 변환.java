import java.util.*;

class Solution {
    static class Node {
        String word;
        int depth;
        
        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        boolean exists = false;
        for (String word : words) {
            if (word.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;
        
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new Node(begin, 0));
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.word.equals(target)) {
                return current.depth;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && check(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], current.depth + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean check(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) return false;
        }
        
        return count == 1;
    }
}