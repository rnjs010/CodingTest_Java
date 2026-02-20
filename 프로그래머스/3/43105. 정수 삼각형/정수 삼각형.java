class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = triangle.clone();
        int size = dp.length;
        
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i-1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i-1][j-1];
                } else {
                    dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }
        
        int answer = 0;
        for (int n: dp[size - 1]) {
            answer = Math.max(answer, n);
        }
        return answer;
    }
}