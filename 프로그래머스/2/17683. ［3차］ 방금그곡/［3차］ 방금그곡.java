import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<String> mArr = splitMusic(m);
        
        String answer = "";
        int maxT = 0;
        for (String s: musicinfos) {
            String[] info = s.split(",");
            List<String> infoArr = splitMusic(info[3]);
            int time = changeTime(info[0], info[1]);
            int mLen = mArr.size(), infoLen = infoArr.size();
            boolean chk = true;
            if (time - mLen < 0) continue;
            for (int i = 0; i <= time - mLen; i++) {
                chk = true;
                for (int j = 0; j < mLen; j++) {
                    if (!mArr.get(j).equals(infoArr.get((i + j) % infoLen))) {
                        chk = false;
                        break;
                    }
                }
                if (chk) break;
            }
            
            if (chk && (maxT < time)) {
                maxT = time;
                answer = info[2];
            }
        }
        
        if (answer.equals("")) answer = "(None)";
        
        return answer;
    }
    
    public int changeTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        int st = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int et = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        return et - st;
    }
    
    public List<String> splitMusic(String str) {
        List<String> music = new ArrayList<>(); 
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') continue;
            if (i != str.length() - 1 && str.charAt(i + 1) == '#') {
                music.add(str.substring(i, i + 2));
            } else {
                music.add(str.substring(i, i + 1));
            }
        }
        return music;
    }
}