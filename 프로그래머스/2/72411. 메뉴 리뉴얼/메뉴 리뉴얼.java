import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> ans = new ArrayList<>();
        
        for (int c: course) {
            Map<String, Integer> map = new HashMap<>();
            for (String o: orders) {
                char[] ch = o.toCharArray();
                Arrays.sort(ch);
                String sortO = new String(ch);
                comb(sortO, c, 0, new StringBuilder(), map);
            }
            
            int max = 0;
            for (int cnt: map.values()) {
                if (cnt >= 2) max = Math.max(max, cnt);
            }
            
            if (max < 2) continue;
            for (Map.Entry<String, Integer> e: map.entrySet()) {
                if (e.getValue() == max) ans.add(e.getKey());
            }
        }
        
        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    static public void comb(String order, int len, int start, StringBuilder sb, Map<String, Integer> map) {
        if (len == sb.length()) {
            String str = sb.toString();
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            comb(order, len, i + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}