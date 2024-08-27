import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static char[][] board;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static Queue<int[]> q;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o2[0], o1[0]);
				}
				
			});
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == '.') {
						int cnt = 0;
						boolean zero = true;
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d], ny = j + dy[d];
							if (0 <= nx && nx < N && 0 <= ny && ny < N) {
								if (board[nx][ny] == '.') {
									cnt++;
								} else {
									zero = false;
									break;
								}
							}
						}
						if (zero) pq.offer(new int[] {cnt, i, j});
					}
				}
			}
			
			int ans = 0;
			while (!pq.isEmpty()) {
				int[] info = pq.poll();
				int x = info[1], y = info[2];
				if (board[x][y] != '.') continue;
				ans++;
				board[x][y] = '0';
				q = new LinkedList<>();
				check(x, y);
				
				while (!q.isEmpty()) {
					int[] ninfo = q.poll();
					check(ninfo[0], ninfo[1]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == '.') ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	public static void check(int x, int y) {
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d], ny = y + dy[d];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == '.') {
				int bomb = 0;
				for (int d2 = 0; d2 < 8; d2++) {
					int nnx = nx + dx[d2], nny = ny + dy[d2];
					if (0 <= nnx && nnx < N && 0 <= nny && nny < N && board[nnx][nny] == '*') {
						bomb++;
					}
				}
				if (bomb == 0) q.add(new int[] {nx, ny});
				board[nx][ny] = (char) (bomb + '0');
			}
		}
	}

}