import java.util.*;

class Solution {
    class Work implements Comparable<Work> {
        String name;
        int start, run;
        
        public Work(String name, int start, int run) {
            this.name = name;
            this.start = start;
            this.run = run;
        }
        
        @Override
        public int compareTo(Work w) {
            return Integer.compare(this.start, w.start);
        }
    }
    
    public String[] solution(String[][] plans) {
        PriorityQueue<Work> pq = new PriorityQueue<>();
        for (String[] p: plans) {
            String[] str = p[1].split(":");
            int start = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
            int run = Integer.parseInt(p[2]);
            pq.add(new Work(p[0], start, run));
        }
        
        List<String> ans = new ArrayList<>();
        Deque<Work> wait = new ArrayDeque<>();
        int curT = 0;
        while (!pq.isEmpty()) {
            Work cur = pq.poll();
            curT = cur.start;

            if (pq.isEmpty()) {
                ans.add(cur.name);
                break;
            }
            Work next = pq.peek();
            int gap = next.start - curT;

            if (cur.run > gap) {
                cur.run -= gap;
                wait.offerLast(cur);
            } else {
                ans.add(cur.name);
                curT += cur.run;
                int remainTime = gap - cur.run;
                while (!wait.isEmpty() && remainTime > 0) {
                    Work w = wait.pollLast();
                    if (w.run > remainTime) {
                        w.run -= remainTime;
                        wait.offerLast(w);
                        break;
                    } else {
                        remainTime -= w.run;
                        ans.add(w.name);
                    }
                }
            }
        }
        
        while (!wait.isEmpty()) {
            ans.add(wait.pollLast().name);
        }
        
        return ans.toArray(new String[0]);
    }
}