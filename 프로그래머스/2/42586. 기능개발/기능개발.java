import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[speeds.length];
        for (int i = 0; i < speeds.length; i++) {
            int left = 100 - progresses[i];
            int add = left / speeds[i];
            if (left % speeds[i] == 0) {
                days[i] = add;
            } else {
                days[i] = add + 1;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int cnt = 1, pre = days[0];
        for (int i = 1; i < days.length; i++) {
            if (days[i] > pre) {
                ans.add(cnt);
                cnt = 1;
                pre = days[i];
            } else {
                cnt += 1;
            }
        }
        ans.add(cnt);
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}