import java.io.*;

public class Main {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    sb.append((1 << n) - 1).append('\n'); // 2^n - 1
    solve(1, 3, n);

    System.out.print(sb.toString());
  }

  public static void solve(int a, int b, int n) {
    if (n == 1) {
      sb.append(a).append(' ').append(b).append('\n');
      return;
    }
    solve(a, 6-a-b, n-1);
    sb.append(a).append(' ').append(b).append('\n');
    solve(6-a-b, b, n-1);
  }
}