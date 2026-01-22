import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = editMusic(m);

        String answer = "(None)";
        int maxT = 0;
        for (String s : musicinfos) {
            String[] info = s.split(",");

            int time = changeTime(info[0], info[1]);
            if (time <= maxT) continue;

            String infoMusic = editMusic(info[3]);

            StringBuilder played = new StringBuilder();
            for (int i = 0; i < time; i++) {
                played.append(infoMusic.charAt(i % infoMusic.length()));
            }

            if (played.toString().contains(m)) {
                maxT = time;
                answer = info[2];
            }
        }

        return answer;
    }

    public int changeTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        int st = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int et = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        return et - st;
    }

    public String editMusic(String str) {
        str = str.replaceAll("C#", "V");
        str = str.replaceAll("D#", "W");
        str = str.replaceAll("F#", "X");
        str = str.replaceAll("G#", "Y");
        str = str.replaceAll("A#", "Z");
        str = str.replaceAll("E#", "v");
        str = str.replaceAll("B#", "w");
        return str;
    }
}
