import java.util.*;

class Solution {
    static Deque<Character> stack = new ArrayDeque<>();

    public int solution(String s) {
        int n = s.length();
        if (n % 2 == 1) return 0;
        int answer = 0;

        for (int start = 0; start < n; start++) {
            char first = s.charAt(start);
            if (first == ')' || first == ']' || first == '}') continue;
            
            if (check(s, start, n)) answer++;
        }
        return answer;
    }

    static boolean check(String s, int start, int n) {
        stack.clear();

        for (int i = 0; i < n; i++) {
            char c = s.charAt((start + i) % n);
            if (c == '(' || c == '[' || c == '{') {
                stack.offerLast(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pollLast();
                if (!isMatch(top, c)) return false;
            }
        }
        return stack.isEmpty();
    }

    static boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
