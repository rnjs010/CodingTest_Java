import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int people = timetable.length;
        int[] crew = new int[people];
        for (int i = 0; i < people; i++) {
            crew[i] = changeT(timetable[i]);
        }
        Arrays.sort(crew);
        
        int[] bus = new int[n];
        for (int i = 0; i < n; i++) {
            bus[i] = 540 + (i * t);
        }
        
        int cIdx = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = 0;
            for (int x = 0; x < m; x++) {
                if (cIdx < people && bus[i] >= crew[cIdx]) {
                    cIdx++;
                    total++;
                }
            }
        }
        
        int ans = (total != m) ? bus[n - 1] : crew[cIdx - 1] - 1; 
        String hh = String.format("%02d", ans / 60);
        String mm = String.format("%02d", ans % 60);
        String answer = hh + ":" + mm;
        return answer;
    }
    
    public int changeT(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}