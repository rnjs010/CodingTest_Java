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
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            boolean result = true;
            
            for (int i = 0; i < str.length(); i++) {
            	char now = str.charAt(i);
            	if (now == '(' || now == '{' || now == '[' || now == '<') {
            		s.add(now);
            	}
            	else if (now == ')') {
            		if (!s.isEmpty() && s.peek() == '(') s.pop();
            		else result = false;
            	}
            	else if (now == '}') {
            		if (!s.isEmpty() && s.peek() == '{') s.pop();
            		else result = false;
            	}
            	else if (now == ']') {
            		if (!s.isEmpty() && s.peek() == '[') s.pop();
            		else result = false;
            	}
            	else if (now == '>') {
            		if (!s.isEmpty() && s.peek() == '<') s.pop();
            		else result = false;
            	}
            	
            }
             
            System.out.println("#" + tc + " " + (result ? 1 : 0));
        }
    }
}