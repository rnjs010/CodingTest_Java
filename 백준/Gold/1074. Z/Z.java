import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    System.out.print(solve(n, r, c));
  }

  public static int solve(int n, int r, int c) {
    if (n == 0) return 0;
    int half = 1 << (n - 1); // 1 * 2^(n-1)
    if (r < half && c < half) return solve(n - 1, r, c);  // 왼쪽 위 사각형
    if (r < half && c >= half) return half * half + solve(n - 1, r, c - half);  // 오른쪽 위 사각형
    if (r >= half && c < half) return 2 * half * half + solve(n - 1, r - half, c); // 왼쪽 아래 사각형
    return 3 * half * half + solve(n - 1, r - half, c - half);  // 오른쪽 아래 사각형
  }
}