class Solution {
    static int answer = 0;
    static boolean[] col, diag1, diag2;
    static int N;

    public int solution(int n) {
        N = n;
        col = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];

        dfs(0);
        return answer;
    }

    static void dfs(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (col[c] || diag1[row + c] || diag2[row - c + N - 1]) {
                continue;
            }

            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + N - 1] = true;

            dfs(row + 1);

            col[c] = false;
            diag1[row + c] = false;
            diag2[row - c + N - 1] = false;
        }
    }
}
