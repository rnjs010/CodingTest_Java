class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int range = w * 2 + 1;
        for (int s: stations) {
            int cnt = s - w - start;
            start = s + w + 1;
            if (cnt < 0) continue;
            answer += cnt / range;
            if (cnt % range != 0) answer++;
        }
        if (start <= n) {
            int cnt = n - start + 1;
            answer += cnt / range;
            if (cnt % range != 0) answer++;
        }

        return answer;
    }
}