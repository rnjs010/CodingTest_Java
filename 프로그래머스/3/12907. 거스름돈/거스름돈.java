// 처음엔 dfs(중복조합)으로 풀이함 => 시간 초과
// dp로 풀어야 함

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int coin: money) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[n];
    }

}