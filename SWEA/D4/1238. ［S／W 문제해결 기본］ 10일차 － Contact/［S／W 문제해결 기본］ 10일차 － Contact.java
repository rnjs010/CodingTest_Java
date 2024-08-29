import java.io.*;
import java.util.*;

class Solution {
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] ans;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	for (int t = 1; t <= 10; t++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		int S = Integer.parseInt(st.nextToken());
    		
    		ans = new int[101];
    		Arrays.fill(ans, Integer.MAX_VALUE);
    		graph = new ArrayList[101];
    		for (int i = 0; i < 101; i++) {
    			graph[i] = new ArrayList<>();
    		}
    		
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < (N/2); i++) {
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			if (!graph[a].contains(b)) {
    		        graph[a].add(b);
    		    }
    		}
 
    		dfs(S, 0);
    		int max_d = 0, result = 0;
    		for (int i = 100; i > 0; i--) {
    			if (ans[i] != Integer.MAX_VALUE) {
    				if (max_d < ans[i]) {
    					max_d = ans[i];
    					result = i;
    				} else if (max_d == ans[i]) {
    					result = Math.max(result, i);
    				}
    			}
    		}
    		System.out.println("#" + t + " " + result);
    	}
    }
    
    public static void dfs(int v, int depth) {
    	if (depth >= ans[v]) return;
    	ans[v] = depth;
    	for (int next : graph[v]) {
    		dfs(next, depth + 1);
    	}
    }
}