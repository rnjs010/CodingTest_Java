/* 중간값 위치보다 큰 경우, 그래프 두 개 생성 */
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] S;
    static int[] B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 1, 0, 0);
        System.out.println(answer);
    }

    private static void DFS(int level, int s, int b, int selectedCount) {
        if(level == N) {  //모든 조합 찾음
            if(selectedCount != 0 && Math.abs(s-b) < answer)
                answer = Math.abs(s-b);
            return;
        }
        DFS(level+1, s*S[level], b+B[level], selectedCount+1);
        DFS(level+1, s, b, selectedCount);
    }
}