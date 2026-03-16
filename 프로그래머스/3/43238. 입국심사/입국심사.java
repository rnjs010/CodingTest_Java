class Solution {
    public long solution(int n, int[] times) {
        long l = 1;
        long r = 0;
        for (int t: times) {
            r = Math.max(r, t);
        }
        r *= n;
        
        long answer = r;
        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = 0;
            for (int t: times) {
                sum += mid / t;
            }
            
            if (sum >= n) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return answer;
    }
}