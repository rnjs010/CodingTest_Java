import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k--;
        for (int i = 0; i < n; i++) {
            long blockSize = fact[n - 1 - i];
            int idx = (int) (k / blockSize);

            answer[i] = nums.get(idx);
            nums.remove(idx);

            k %= blockSize;
        }

        return answer;
    }
}
