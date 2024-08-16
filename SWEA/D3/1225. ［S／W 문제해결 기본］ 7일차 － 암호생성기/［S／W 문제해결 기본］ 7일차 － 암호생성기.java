import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++)
        {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < 8; i++) q.add(Integer.parseInt(st.nextToken()));
            
            boolean chk = true;
            while(chk) {
            	for (int j = 1; j < 6; j++) {
            		int tmp = q.poll() - j;
            		if (tmp <= 0) {
            			q.add(0);
            			chk = false;
            			break;
            		} else {
            			q.add(tmp);
            		}
            	}
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i : q) {
            	if (sb.length() > 0) sb.append(" ");
            	sb.append(i);
            }
            System.out.println("#" + tc + " " + sb.toString());           
        }
    }
}