import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (String str: operations) {
            String[] s = str.split(" ");
            int num = Integer.parseInt(s[1]);
            
            if (s[0].equals("I")) {
                maxPQ.add(num);
                minPQ.add(num);
                map.put(num, map.getOrDefault(map.get(num), 0) + 1);
            } else if (s[0].equals("D") && num == 1) {
                while(!maxPQ.isEmpty() && map.get(maxPQ.peek()) == 0) {
                    maxPQ.poll();
                }
                if (!maxPQ.isEmpty()) {
                    int n = maxPQ.poll();
                    map.put(n, map.get(n) - 1);
                }
            } else {
                while(!minPQ.isEmpty() && map.get(minPQ.peek()) == 0) {
                    minPQ.poll();
                }
                if (!minPQ.isEmpty()) {
                    int n = minPQ.poll();
                    map.put(n, map.get(n) - 1);
                }
            }
        }
        
        int[] answer = new int[2];
        while(!maxPQ.isEmpty() && map.get(maxPQ.peek()) == 0) {
            maxPQ.poll();
        }
        while(!minPQ.isEmpty() && map.get(minPQ.peek()) == 0) {
            minPQ.poll();
        }
        if (!maxPQ.isEmpty()) {
            answer[0] = maxPQ.peek();
            answer[1] = minPQ.peek();
        }
        return answer;
    }
}