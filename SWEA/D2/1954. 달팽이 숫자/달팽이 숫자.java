import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int x = 0, y = -1;
            int num = 1, k = 0, dist = N, cnt = 1;
 
            while (num <= N*N) {
                if (cnt == 2) {
                    cnt = 0;
                    dist -= 1;
                }
                 
                for (int i = 0; i < dist; i++) {
                    x += dx[k % 4];
                    y += dy[k % 4];
                    arr[x][y] = num++;
                }
                cnt++;
                k++;
            }
             
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d ", arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}