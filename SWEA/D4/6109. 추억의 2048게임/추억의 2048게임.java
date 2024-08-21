import java.io.*;
import java.util.*;

class Solution {
	static int N;
	static String S;
	static int[][] board, new_board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			new_board = new int[N][N];
			if (S.equals("up")) up();
			if (S.equals("down")) down();
			if (S.equals("right")) right();
			if (S.equals("left")) left();
			
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(new_board[i][j] + " ");
				}
				System.out.println();
			}
		}

	}
	
	public static Deque<Integer> push(Queue<Integer> q) {
		Deque<Integer> res = new LinkedList<>();
		boolean chk = true;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			if (tmp == 0) continue;
			if (res.isEmpty() || chk == false) {
				res.addLast(tmp);
				chk = true;
			} else {
				if (res.peekLast() == tmp) {
					res.pollLast();
					res.addLast(tmp*2);
					chk = false;
				} else {
					res.addLast(tmp);
				}
			}
		}
		return res;
	}
	
	public static void up() {
		for (int j = 0; j < N; j++) {
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < N; i++) q.add(board[i][j]);

			Deque<Integer> res = push(q);
			for (int i = 0; i < N; i++) {
				if (!res.isEmpty()) new_board[i][j] = res.pollFirst();
			}
		}
	}
	
	public static void down() {
		for (int j = 0; j < N; j++) {
			Queue<Integer> q = new LinkedList<>();
			for (int i = N-1; i >= 0 ; i--) q.add(board[i][j]);
			
			Deque<Integer> res = push(q);
			for (int i = N-1; i >= 0 ; i--) {
				if (!res.isEmpty()) new_board[i][j] = res.pollFirst();
			}
		}
	}
	
	public static void right() {
		for (int i = 0; i < N; i++) {
			Queue<Integer> q = new LinkedList<>();
			for (int j = N-1; j >= 0; j--) q.add(board[i][j]);
			
			Deque<Integer> res = push(q);
			for (int j = N-1; j >= 0; j--) {
				if (!res.isEmpty()) new_board[i][j] = res.pollFirst();
			}
		}
	}
	
	public static void left() {
		for (int i = 0; i < N; i++) {
			Queue<Integer> q = new LinkedList<>();
			for (int j = 0; j < N; j++) q.add(board[i][j]);
			
			Deque<Integer> res = push(q);
			for (int j = 0; j < N; j++) {
				if (!res.isEmpty()) new_board[i][j] = res.pollFirst();
			}
		}
	}

}