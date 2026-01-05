class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int s = 0, e = 0;
        long sum = 0;

        int minLen = n + 1;
        int ansS = 0, ansE = 0;

        while (e < n) {
            sum += sequence[e];

            while (sum >= k) {
                if (sum == k) {
                    int len = e - s + 1;
                    if (len < minLen) {
                        minLen = len;
                        ansS = s;
                        ansE = e;
                    }
                }
                sum -= sequence[s++];
            }

            e++;
        }

        return new int[]{ansS, ansE};
    }
}
