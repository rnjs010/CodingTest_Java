import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int a = 0, b = 0;
        int size = A.length;
        while (b < size && a < size) {
            if (A[a] < B[b]) {
                answer++;
                a++;
            }
            b++;
        }
        
        return answer;
    }
}