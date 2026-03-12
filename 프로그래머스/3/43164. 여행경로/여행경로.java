import java.util.*;

class Solution {
    String[][] tickets;
    String[] path;
    boolean[] use;
    int n;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        path = new String[n + 1];
        use = new boolean[n];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        this.tickets = tickets;
        path[0] = "ICN";
        dfs(0, "ICN");
        return path;
    }
    
    public boolean dfs(int depth, String cur) {
        if (depth == n) {
            return true;
        }
        
        for (int i = 0; i < n; i++) {
            if (cur.equals(tickets[i][0]) && !use[i]) {
                path[depth + 1] = tickets[i][1];
                use[i] = true;
                if (dfs(depth + 1, tickets[i][1])) {
                    return true;
                }
                use[i] = false;
            }
        }
        return false;
    }
}