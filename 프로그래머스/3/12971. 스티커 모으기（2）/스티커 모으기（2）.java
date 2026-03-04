class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n == 1) return sticker[0];
        
        // case1: 0번 포함 (마지막 제외)
        int[] dp = new int[n];
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        
        // case2: 0번 미포함
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        
        // case1의 경우 마지막 인덱스 주의
        return Math.max(dp[n - 2], dp2[n - 1]);
    }
}