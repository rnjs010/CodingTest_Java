import java.util.*;

class Solution {
    public long solution(String expression) {
        Deque<Long> numbers = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        
        StringBuilder sb = new StringBuilder();
        for (char c: expression.toCharArray()) {
            if (c == '*' || c == '-' || c == '+') {
                numbers.add(Long.parseLong(sb.toString()));
                ops.add(c);
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));
        
        char[][] priorities = {
            {'+', '-', '*'}, {'+', '*', '-'},
            {'-', '+', '*'}, {'-', '*', '+'},
            {'*', '+', '-'}, {'*', '-', '+'}
        };
        
        long answer = 0;
        for (char[] p: priorities) {
            Deque<Long> num = new ArrayDeque<>(numbers);
            Deque<Character> op = new ArrayDeque<>(ops);
            
            for (char c: p) {
                Deque<Long> nNum = new ArrayDeque<>();
                Deque<Character> nOp = new ArrayDeque<>();
                
                nNum.add(num.pollFirst());
                while (!op.isEmpty()) {
                    char curOp = op.pollFirst();
                    long curNum = num.pollFirst();
                    if (curOp == c) {
                        nNum.add(calc(nNum.pollLast(), curNum, curOp));
                    } else {
                        nNum.add(curNum);
                        nOp.add(curOp);
                    }
                }
                
                num = nNum;
                op = nOp;
            }
            
            answer = Math.max(answer, Math.abs(num.peek()));
        }
        
        return answer;
    }
    
    public long calc(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }
}