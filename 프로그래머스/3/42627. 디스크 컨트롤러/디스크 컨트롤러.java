// SJF - 현재 시간까지 들어온 것들 중 가장 짧은 것
import java.util.*;

class Solution {
    static class Job implements Comparable<Job> {
        int start, time;
        public Job (int start, int time) {
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo (Job other) {
            return this.time - other.time;
        }
    }
    
    public int solution(int[][] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);  // 요청 시간 순으로 정렬
        PriorityQueue<Job> pq = new PriorityQueue<>();  // 대기큐
        
        int answer = 0, curTime = 0;
        int idx = 0, cnt = 0;
        while (cnt < n) {  // 대기큐에서 모두 제거될 때까지 반복
            // 현재 시간보다 요청 시간이 작거나 같은 모든 작업 대기큐에 추가
            while (idx < n && jobs[idx][0] <= curTime) {
                pq.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if (!pq.isEmpty()) {  // 대기큐가 비어있지 않으면
                Job j = pq.poll();  // 대기큐에서 빼기
                curTime += j.time;  // 작업 시간만큼 더하기
                answer += (curTime - j.start);  // 대기부터 종료까지 걸린 시간 더하기
                cnt++;
            } else {
                curTime = jobs[idx][0];  // 대기큐가 비어있다면, 다음 작업 요청 시간으로 현재 시간 변경하기
            }
        }

        
        return answer / n;
    }
}