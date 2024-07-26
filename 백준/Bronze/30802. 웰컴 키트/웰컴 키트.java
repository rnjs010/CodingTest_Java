import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
	    int[] arr = new int[6];
	    for (int i = 0; i < 6; i++) {
	    	arr[i] = Integer.parseInt(st.nextToken());
	    }
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
	    int P = Integer.parseInt(st.nextToken());
	    
	    int T_ans = 0, P_ans = 0, one_ans = 0;
	    for (int val : arr) {
	    	T_ans += (val / T);
	    	if (val % T > 0) { T_ans++; }
	    }
	    
	    P_ans += (N / P);
	    one_ans += (N % P);
	    
	    System.out.println(T_ans);
	    System.out.println(P_ans + " " + one_ans);
	}
}