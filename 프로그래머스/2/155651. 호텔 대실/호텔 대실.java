import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            time[i] = changeTime(book_time[i]);
        }
        Arrays.sort(time, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] t: time) {
            if (!pq.isEmpty() && pq.peek() <= t[0]) {
                pq.poll();
            }
            pq.offer(t[1]);
        }
        
        int answer = pq.size();
        return answer;
    }
    
    static int[] changeTime(String[] bTime) {
        String[] str = bTime[0].split(":");
        int S = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        String[] str2 = bTime[1].split(":");
        int E = Integer.parseInt(str2[0]) * 60 + Integer.parseInt(str2[1]) + 10;
        return new int[] {S, E};
    } 
}