/* BFS (큐) */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	List<Integer>[] tree = new ArrayList[N+1];
        	for (int i = 0; i <= N; i++) {
        		tree[i] = new ArrayList<Integer>();
        	}
        	
        	for (int i = 0; i < (N-1); i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		tree[b].add(a);
        	}
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int node1 = Integer.parseInt(st.nextToken());
        	int node2 = Integer.parseInt(st.nextToken());
        	
        	int ans = 0;
        	
            ArrayList<Integer> p1dst = new ArrayList<>();
            ArrayList<Integer> p2dst = new ArrayList<>();

            int dst = node1;
            while (dst != 0) {
                p1dst.add(dst);
                if (tree[dst].isEmpty()) {
                	dst = 0;
                	break;
                }
                dst = tree[dst].get(0);
            }

            dst = node2;
            while (dst != 0) {
                p2dst.add(dst);
                if (tree[dst].isEmpty()) {
                	dst = 0;
                	break;
                }
                dst = tree[dst].get(0);
            }

            int len1 = p1dst.size(), len2 = p2dst.size();
        	int min_len = Math.min(len1, len2);
        	for (int i = 1; i <= min_len; i++) {
        		if (p1dst.get(len1-i).equals(p2dst.get(len2-i))) {
        			ans = p1dst.get(len1-i);
        		}
        	}
        
        	System.out.println(ans);
        }

	}
    
}

