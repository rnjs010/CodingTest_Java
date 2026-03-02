class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int range = w * 2 + 1;
        for (int s: stations) {
            int left = s - w;
            if (start < left) {
                int gap = left - start;
                answer += (gap + range - 1) / range;  // 올림 나눗셈 공식 적용
            }
            start = s + w + 1;
        }
        
        if (start <= n) {
            int gap = n - start + 1;
            answer += (gap + range - 1) / range;
        }

        return answer;
    }
}