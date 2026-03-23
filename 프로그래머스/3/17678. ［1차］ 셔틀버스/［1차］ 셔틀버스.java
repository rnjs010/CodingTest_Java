import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int people = timetable.length;
        int[] crew = new int[people];
        for (int i = 0; i < people; i++) {
            crew[i] = changeT(timetable[i]);
        }
        Arrays.sort(crew);
        
        int cIdx = 0;
        int total = 0;
        int lastB = 0;
        for (int i = 0; i < n; i++) {
            int busT = 540 + (i * t);
            lastB = busT;
            total = 0;
            while (cIdx < people && busT >= crew[cIdx] && total < m) {
                cIdx++;
                total++;
            }
        }
        
        int ans = (total < m) ? lastB : crew[cIdx - 1] - 1; 
        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
    
    public int changeT(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}