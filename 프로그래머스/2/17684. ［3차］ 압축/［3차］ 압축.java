import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> ans = new ArrayList<>();
        
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            String a = "";
            a += (char) (64 + i);
            dict.put(a, i);
        }
        
        int s = 0, e = 0, find = 0, last = 27;
        while (e < msg.length()) {
            while (true) {
                String sub = msg.substring(s, e + 1);
            
                if (dict.containsKey(sub)) {
                    find = dict.get(sub);
                    e++;
                    if (e == msg.length()) {
                        ans.add(find);
                        break;
                    }
                } else {
                    ans.add(find);
                    dict.put(sub, last++);
                    s = e;
                    break;
                }
            }
            
        }
        
        int n = ans.size();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}