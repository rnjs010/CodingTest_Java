class Solution {
    public int[][] solution(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int tmp = (n >= m) ? n : m;
        int[][] answer = new int[tmp][tmp];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}