import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (String str: operations) {
            if (str.charAt(0) == 'I') {
                int num = Integer.parseInt(str.substring(2));
                maxPQ.add(num);
                minPQ.add(num);
            } else if (str.equals("D 1") && !maxPQ.isEmpty()) {
                minPQ.remove(maxPQ.poll());
            } else if (str.equals("D -1") && !minPQ.isEmpty()) {
                maxPQ.remove(minPQ.poll());
            }
        }
        
        int[] answer = new int[2];
        if (!maxPQ.isEmpty()) {
            answer = new int[]{maxPQ.peek(), minPQ.peek()};
        }
        return answer;
    }
}