class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            int a = n % 3;
            n /= 3;
            if (a == 0) {
                sb.append(4);
                n--;
                continue;
            }
            sb.append(a);
        }
        
        String answer = sb.reverse().toString();
        return answer;
    }
}