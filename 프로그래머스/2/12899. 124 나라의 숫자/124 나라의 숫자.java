class Solution {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            int a = n % 3;
            n /= 3;
            sb.append(num[a]);
            if (a == 0) {
                n--;
            }
        }
        
        String answer = sb.reverse().toString();
        return answer;
    }
}