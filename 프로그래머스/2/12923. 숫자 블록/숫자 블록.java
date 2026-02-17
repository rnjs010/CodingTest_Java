class Solution {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            long n = begin + i;
            if (n == 1) {
                answer[i] = 0;
                continue;
            }

            int result = 1;
            for (long x = 2; x * x <= n; x++) {
                if (n % x == 0) {
                    long partner = n / x;
                    if (partner <= 10_000_000) {
                        result = (int) partner;
                        break;
                    }

                    if (x <= 10_000_000) {
                        result = (int) x;
                    }
                }
            }

            answer[i] = result;
        }

        return answer;
    }
}
