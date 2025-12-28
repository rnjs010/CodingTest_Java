class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder(t);
        
        int num = 0;
        int order = 0;

        while (answer.length() < t) {
            String s = Integer.toString(num++, n).toUpperCase();
            
            for (int i = 0; i < s.length(); i++) {
                if (order % m == p - 1) {
                    answer.append(s.charAt(i));
                    if (answer.length() == t) break;
                }
                order++;
            }
        }
        return answer.toString();
    }
}