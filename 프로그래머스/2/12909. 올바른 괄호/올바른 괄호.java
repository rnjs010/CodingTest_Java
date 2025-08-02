import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<String> stk = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.addLast("(");
            } else if (s.charAt(i) == ')' && stk.isEmpty()) {
                return false;
            } else {
                stk.pollLast();
            }
        }
        
        return (stk.isEmpty()) ? true : false;
    }
}