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
    
    PriorityQueue<Work> pq = new PriorityQueue<>();
    
    public String[] solution(String[][] plans) {
        for (String[] p: plans) {
            change(p);
        }
        
        List<String> ans = new ArrayList<>();
        Deque<Work> wait = new ArrayDeque<>();
        int curT = 0;
        while(!pq.isEmpty()) {
            Work cur = pq.poll();
            curT = cur.start;
            if (pq.isEmpty()) {
                ans.add(cur.name);
                break;
            }
            Work next = pq.peek();
            if (curT + cur.run == next.start) {
                ans.add(cur.name);
                continue;
            } else if (curT + cur.run > next.start) {
                int left = cur.run - (next.start - curT);
                wait.offer(new Work(cur.name, cur.start, left));
                continue;
            } else {
                curT += cur.run;
                ans.add(cur.name);
                while (!wait.isEmpty()) {
                    Work w = wait.pollLast();
                    if (curT + w.run == next.start) {
                        ans.add(w.name);
                        break;
                    } else if (curT + w.run > next.start) {
                        int left = w.run - (next.start - curT);
                        wait.offer(new Work(w.name, w.start, left));
                        break;
                    } else {
                        ans.add(w.name);
                        curT += w.run;
                    }
                }
            }
        }
        
        while (!wait.isEmpty()) {
            ans.add(wait.pollLast().name);
        }
        
        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    public void change(String[] plan) {
        String[] str = plan[1].split(":");
        int start = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        int run = Integer.parseInt(plan[2]);
        pq.add(new Work(plan[0], start, run));
        return;
    }
}