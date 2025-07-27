import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        char[] str = my_string.toCharArray();
        
        Boolean[] contain = new Boolean[str.length];
        Arrays.fill(contain, true);
        for (int i = 0; i < indices.length; i++) {
            contain[indices[i]] = false;
        }
        
        for (int i = 0; i < str.length; i++) {
            if (contain[i] == true) {
                answer += str[i];
            }
        }
        
        return answer;
    }
}