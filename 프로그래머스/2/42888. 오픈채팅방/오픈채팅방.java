import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> name = new HashMap<>();
        List<String[]> li = new ArrayList<>();
        
        for (String str: record) {
            String[] s = str.split(" ");
            if (s[0].equals("Change")) {
                name.put(s[1], s[2]);    
            } else if (s[0].equals("Enter")) {
                li.add(new String[] {s[1], "님이 들어왔습니다."});
                name.put(s[1], s[2]);
            } else {
                li.add(new String[] {s[1], "님이 나갔습니다."});
            }
        }
        
        String[] answer = new String[li.size()];
        for (int i = 0; i < li.size(); i++) {
            answer[i] = name.get(li.get(i)[0]) + li.get(i)[1];
        }
        
        return answer;
    }
}