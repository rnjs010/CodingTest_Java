import java.util.*;

class Solution {
    static String ss;
    public int solution(String s) {
        int answer = 0;
        ss = s + s;
        for (int i = 0; i < s.length(); i++) {
            if (check(i)) answer++;
        }
        
        return answer;
    }
    
    static public boolean check(int x) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = x; i < x + ss.length() / 2; i++) {
            char c = ss.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                dq.offerLast(c);
            } else {
                if (dq.isEmpty()) {
                    return false;
                }
                char top = dq.peekLast();
                if ((top == '{' && c == '}') || (top == '[' && c == ']') || (top == '(' && c == ')')) {
                    dq.pollLast();
                } else {
                    return false;
                }
            }
        }
        if (!dq.isEmpty()) return false;
        return true;
    }
}