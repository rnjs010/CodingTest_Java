import java.util.*;

class Solution {
    String[] temp;
    boolean[] use;
    int n;
    String[][] tickets;
    String[] answer = {};
    boolean check = false;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        temp = new String[n + 1];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        this.tickets = tickets;
        
        for (int i = 0; i < n; i++) {
            use = new boolean[n];
            if (tickets[i][0].equals("ICN")) {
                use[i] = true;
                temp[0] = tickets[i][0];
                temp[1] = tickets[i][1];
                dfs(2, tickets[i]);
                if (check) break;
            }
        }
        
        return answer;
    }
    
    public void dfs(int depth, String[] t) {
        if (check) return;
        if (depth == n + 1) {
            answer = temp.clone();
            check = true;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (t[1].equals(tickets[i][0]) && !use[i]) {
                temp[depth] = tickets[i][1];
                use[i] = true;
                dfs(depth + 1, tickets[i]);
                use[i] = false;
            }
        }
    }
}