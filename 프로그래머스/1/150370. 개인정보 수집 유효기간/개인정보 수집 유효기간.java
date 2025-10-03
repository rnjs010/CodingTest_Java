import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] tDate = changeFormat(today);
        
        Map<String, Integer> term = new HashMap<>();
        for (String str : terms) {
            String[] s = str.split(" ");
            term.put(s[0], Integer.parseInt(s[1]));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            int[] pDate = changeFormat(s[0]);
            int mon = pDate[1] + term.get(s[1]);
            if (mon > 12) {
                if (mon % 12 == 0) {
                    pDate[0] += mon / 12 - 1;
                    mon = 12;
                } else {
                    pDate[0] += mon / 12;
                    mon %= 12;
                }
            }
            pDate[1] = mon;
            
            if (tDate[0] > pDate[0]) {
                ans.add(i+1);
                continue;
            } else if (tDate[0] == pDate[0]) {
                if (tDate[1] > pDate[1]) {
                    ans.add(i+1);
                    continue;
                } else if (tDate[1] == pDate[1]) {
                    if (tDate[2] >= pDate[2]) {
                        ans.add(i+1);
                        continue;
                    }
                }
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i).intValue();
        }
        return answer;
    }
    
    
    static int[] changeFormat(String date) {
        String[] str = date.split("\\.");
        int[] res = new int[3];
        for (int i = 0; i < 3 ; i++) {
            res[i] = Integer.parseInt(str[i]);
        }
        return res;
    }
}