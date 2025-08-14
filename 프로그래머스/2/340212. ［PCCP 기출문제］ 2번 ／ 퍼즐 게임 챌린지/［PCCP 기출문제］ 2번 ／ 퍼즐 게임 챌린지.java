class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int l = 1, r = 100000;
        int answer = r;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            long res = gameTime(mid, diffs, times);
            if (res <= limit) {
                // answer = Math.min(answer, mid);
                answer = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return answer;
    }
    
    static long gameTime(int level, int[] diffs, int[] times) {
        long result = times[0];
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                result += times[i];
            } else {
                result += (times[i-1] + times[i]) * (diffs[i] - level) + times[i];
            }
        }
        return result;
    }
}