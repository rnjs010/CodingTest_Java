class Solution {
    public long solution(int[] sequence) {
        long max = Long.MIN_VALUE;

        long a = 0; // pulse: 1 -1 1 -1
        long b = 0; // pulse: -1 1 -1 1

        for (int i = 0; i < sequence.length; i++) {
            int val = (i % 2 == 0) ? sequence[i] : -sequence[i];

            a = Math.max(val, a + val);
            b = Math.max(-val, b - val);

            max = Math.max(max, Math.max(a, b));
        }

        return max;
    }
}