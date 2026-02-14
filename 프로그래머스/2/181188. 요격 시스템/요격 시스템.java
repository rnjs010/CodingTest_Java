import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int last = Integer.MIN_VALUE;
        for (int[] t: targets) {
            if (t[0] >= last) {
                answer++;
                last = t[1];
            }
        }
        
        return answer;
    }
}