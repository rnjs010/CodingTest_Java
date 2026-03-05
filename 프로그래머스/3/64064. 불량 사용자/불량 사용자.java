/* 비트마스킹 */
import java.util.*;

class Solution {
    Set<Integer> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, 0, banned_id, user_id);
        return result.size();
    }
    
    private boolean possible(String ban, String user) {
        int len = ban.length();
        if (len != user.length()) return false;
        for (int i = 0; i < len; i++) {
            char cur = ban.charAt(i);
            if (cur != '*') {
                if (cur != user.charAt(i)) return false;
            }
        }
        return true;
    }
    
    private void dfs(int depth, int mask, String[] ban, String[] user) {
        if (depth == ban.length) {
            result.add(mask);
            return;
        }
        
        for (int i = 0; i < user.length; i++) {
            if ((mask & (1 << i)) != 0) continue;
            if (possible(ban[depth], user[i])) {
                dfs(depth + 1, mask | (1 << i), ban, user);
            }
        }
    }
}