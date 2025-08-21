class Solution {
    static int cnt = 0, answer = 0;
    static String[] alpha = new String[]{"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        func(0, "", word);
        return answer;
    }
    
    public void func(int len, String str, String word) {
        System.out.println(str);
        if (str.equals(word) || len == 5) {
            if (str.equals(word)) {
                answer = cnt;
            }
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            cnt++;
            func(len+1, str + alpha[i], word);
        }
    }
}