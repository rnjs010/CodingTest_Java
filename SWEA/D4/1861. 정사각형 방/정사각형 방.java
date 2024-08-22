import java.io.*;
import java.util.*;

class Solution {
	static int N;
	static int[][] board;
	static int room, ans;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			room = N*N;
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) dfs(i, j, 1, board[i][j]);
			}
			System.out.println("#" + t + " " + room + " " + ans);
		}

	}
	
	public static void dfs(int x, int y, int cnt, int num) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d], ny = y + dy[d];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == board[x][y] + 1) {
				dfs(nx, ny, cnt + 1, num);
				return;
			}
		}
		
		if (ans < cnt) {
			ans = cnt;
			room = num;
		} else if (ans == cnt) {
			room = Math.min(room, num);
		}
	}
	
}