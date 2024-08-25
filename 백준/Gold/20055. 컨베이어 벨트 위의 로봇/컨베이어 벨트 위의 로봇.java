import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> ro = new ArrayList<>();
        for (int i = 0; i < N; i++) ro.add(0);
        List<Integer> belt = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            belt.add(Integer.parseInt(st.nextToken()));
        }

        int zero = 0, ans = 1;
        while (true) {
            Collections.rotate(belt, 1);
            Collections.rotate(ro, 1);
            ro.set(N-1, 0);

            for (int i = N-2; i >= 0; i--) {
                if (ro.get(i) == 1 && ro.get(i + 1) == 0 && belt.get(i + 1) > 0) {
                    belt.set(i + 1, belt.get(i + 1) - 1);
                    ro.set(i, 0);
                    ro.set(i + 1, 1);
                    if (belt.get(i+1) == 0) zero++;
                }
            }
            ro.set(N-1, 0);

            if (belt.get(0) > 0 && ro.get(0) == 0) {
                ro.set(0, 1);
                belt.set(0, belt.get(0) - 1);
                if (belt.get(0) == 0) zero++;
            }
            if (zero >= K) break;
            ans++;
        }

        System.out.println(ans);
    }
}