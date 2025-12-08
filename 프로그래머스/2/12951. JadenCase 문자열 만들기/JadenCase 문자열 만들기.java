class Solution {
    public String solution(String s) {
        String str = s.toLowerCase();
        char[] strArr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            strArr[i] = str.charAt(i);
        }
        
        boolean wordS = true;
        for (int i = 0; i < s.length(); i++) {
            if (strArr[i] == ' ') {
                wordS = true;
            }
            else if (Character.isDigit(strArr[i])) {
                wordS = false;
            } else if (wordS) {
                strArr[i]  = Character.toUpperCase(strArr[i]);
                wordS = false;
            }
        }
        
        String answer = new String(strArr);
        return answer;
    }
}