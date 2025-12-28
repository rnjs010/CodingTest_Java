import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        int len = 0, a = 0;
        int maxL = p + m * (t - 1);
        while (len < maxL) {
            String s = Integer.toString(a, n);
            sb.append(s);
            a++;
            len += s.length();
        }
        
        String all = sb.toString();
        sb.setLength(0);
        
        for (int i = p; i <= maxL; i += m) {
            sb.append(all.charAt(i - 1));
        }
        String answer = sb.toString().toUpperCase();
        
        return answer;
    }
}