import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String,Integer> phone = new HashMap<>();
        for (String num: phone_book) {
            phone.put(num, 0);
        }
        
        out:
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (phone.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    break out;
                }
            }
        }
        return answer;
    }
}