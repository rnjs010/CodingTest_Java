import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        char[] str = my_string.toCharArray();    
        for (int i = 0; i < str.length; i++) {
            int idx = (int) str[i];
            if (Character.isUpperCase(str[i])) {
                answer[idx - 65] += 1;
            } else {
                answer[idx - 71] += 1;
            }
        }
        return answer;
    }
}