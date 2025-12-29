import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> res = new ArrayList<>();
        
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char) ('A' + i)), i + 1);
        }
        
        int s = 0, find = 0, last = 27;
        while (s < msg.length()) {
            int e = s + 1;
            
            while (e <= msg.length() && dict.containsKey(msg.substring(s, e))) {
                e++;
            }
            
            String w = msg.substring(s, e - 1);
            res.add(dict.get(w));
            
            if (e <= msg.length()) {
                String wc = msg.substring(s, e);
                dict.put(wc, last++);
            }

            s = e - 1;
        }
        
        return res.stream().mapToInt(i -> i).toArray();
    }
}