class Solution {
    public long solution(int[] sequence) {
        int size = sequence.length;
        long[] a = new long[size]; // 1 -1 1 -1
        long[] b = new long[size]; // -1 1 -1 1
        
        for (int i = 0; i < size; i++) {
            int num = sequence[i];
            if (i % 2 == 0) {
                a[i] = num;
                b[i] = num * -1;
            } else {
                b[i] = num;
                a[i] = num * -1;
            }
        }
        
        long answer = Math.max(a[0], b[0]);
        for (int i = 1; i < size; i++) {
            a[i] = Math.max(a[i] + a[i - 1], a[i]);
            b[i] = Math.max(b[i] + b[i - 1], b[i]);
            long temp = Math.max(a[i], b[i]);
            answer = Math.max(answer, temp);
        }
        return answer;
    }
}