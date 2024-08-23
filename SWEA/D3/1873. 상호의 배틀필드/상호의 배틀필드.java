import java.io.*;
import java.util.*;

class Solution {
	static int H, W, N, x, y;
	static char[][] board;
	static String command;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static char[] pos = {'^', '>', 'v', '<'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			board = new char[H][W];
			for (int i = 0; i < H; i++) {
				board[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					for (char p : pos) {
						if (board[i][j] == p) {
							x = i; y = j;
						}
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			command = br.readLine();
			for (int i = 0; i < N; i++) {
				char cmd = command.charAt(i);
				if (cmd == 'U') move(0);
				else if (cmd == 'R') move(1);
				else if (cmd == 'D') move(2);
				else if (cmd == 'L') move(3);
				else if (cmd == 'S') {
					int idx = 0;
					for (int p = 0; p < 4; p++) {
						if (board[x][y] == pos[p]) {
							idx = p;
							break;
						}
					}
					int bx = x + dx[idx], by = y + dy[idx];
					while (true) {
						if ((!(0 <= bx && bx < H)) || (!(0 <= by && by < W))) break;
						else if (board[bx][by] == '#') break;
						else if (board[bx][by] == '*') {
							board[bx][by] = '.';
							break;
						}
						bx += dx[idx]; by += dy[idx];
					}
				}
			}
			
			System.out.print("#" + t + " ");
			StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < H; i++) {
	            for (int j = 0; j < W; j++) {
	                sb.append(board[i][j]);
	            }
	            sb.append('\n');
	        }
	        System.out.print(sb.toString());
		}
	}
	
	public static void move(int d) {
		board[x][y] = pos[d];
		int nx = x + dx[d], ny = y + dy[d];
		if (0 <= nx && nx < H && 0 <= ny && ny < W && board[nx][ny] == '.') {
			board[nx][ny] = pos[d]; board[x][y] = '.';
			x = nx; y = ny;
		}
	}
}