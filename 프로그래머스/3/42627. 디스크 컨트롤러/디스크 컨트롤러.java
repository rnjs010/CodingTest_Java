import java.util.*;

class Solution {
    class Job implements Comparable<Job> {
        int start, time;
        
        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo(Job other) {
            return this.time - other.time;
        }
    }
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int curTime = 0;
        int idx = 0;
        int total = 0;
        int count = 0;
        
        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= curTime) {
                pq.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if (!pq.isEmpty()) {
                Job j = pq.poll();
                curTime += j.time;
                total += (curTime - j.start);
                count++;
            } else {
                curTime = jobs[idx][0];
            }
        }
        
        return total / jobs.length;
    }
}