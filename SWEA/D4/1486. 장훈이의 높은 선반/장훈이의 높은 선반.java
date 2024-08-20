import java.io.*;
import java.util.*;

class Solution {
	static int N, B;
	static int[] heights;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			heights = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.println("#" + t + " " + (ans - B));
		}
	}
	
	public static void dfs(int idx, int sum) {
		if (idx == N) {
			if (sum >= B) {
				ans = Math.min(ans, sum);
			}
			return;
		}
		dfs(idx + 1, sum + heights[idx]);
		dfs(idx + 1, sum);
	}
}