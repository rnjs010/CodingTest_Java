import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stk.isEmpty()) {
                stk.push(arr[i]);
            } else {
                if (stk.peek() == arr[i]) {
                    stk.pop();
                } else {
                    stk.push(arr[i]);
                }
            }
        }
        
        int[] answer;
        if (stk.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[stk.size()];
            for (int i = stk.size() - 1; i >= 0; i--) {
                answer[i] = stk.pop();
            }
        }
        return answer;
    }
}