/* dfs, set */
import java.util.*;

class Solution {
    Set<String> result = new HashSet<>();
    List<String> temp = new ArrayList<>();
    int len;
    List<String>[] candidates;
    
    public int solution(String[] user_id, String[] banned_id) {
        len = banned_id.length;
        candidates = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            candidates[i] = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                if (possible(banned_id[i], user_id[j])) {
                    candidates[i].add(user_id[j]);
                }
            }
        }
        
        dfs(0);
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
    
    private void dfs(int depth) {
        if (depth == len) {
            List<String> list = new ArrayList<>(temp);
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (String s: list) {
                sb.append(s).append("|");
            }
            result.add(sb.toString());
            return;
        }
        
        for (String id: candidates[depth]) {
            if (temp.contains(id)) continue;
            temp.add(id);
            dfs(depth + 1);
            temp.remove(temp.size() - 1);
        }
    }
}