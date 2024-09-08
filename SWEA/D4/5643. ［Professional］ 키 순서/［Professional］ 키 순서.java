import java.io.*;
import java.util.*;

class Solution {
    static int N, M, ans;
    static ArrayList<Integer>[] t_graph, s_graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            t_graph = new ArrayList[N+1];
            s_graph = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) {
                t_graph[i] = new ArrayList<>();
                s_graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                t_graph[a].add(b);
                s_graph[b].add(a);
            }

            ans = 0;
            for (int i = 1; i <= N; i++) {
                int tall = Count(i, new boolean[N+1], t_graph);
                int small = Count(i, new boolean[N+1], s_graph);
                if (tall + small == N-1) ans++;
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    public static int Count(int n, boolean[] visit, ArrayList<Integer>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }

}