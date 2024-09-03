import java.io.*;
import java.util.*;

public class Main {
    static int N, D, K, C, ans = 0;
    static int[] dish, visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dish = new int[N];
        visited = new int[D + 1];
        for (int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        slide();
        System.out.println(ans);
    }

    public static void slide() {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            if (visited[dish[i]] == 0) cnt++;
            visited[dish[i]]++;
        }
        ans = visited[C] == 0 ? cnt + 1 : cnt;

        for (int i = 1; i < N; i++) {
            visited[dish[i - 1]]--;
            if (visited[dish[i - 1]] == 0) cnt--;

            if (visited[dish[(i + K - 1) % N]] == 0) cnt++;
            visited[dish[(i + K - 1) % N]]++;

            int currentMax = visited[C] == 0 ? cnt + 1 : cnt;
            ans = Math.max(ans, currentMax);
        }
    }
}