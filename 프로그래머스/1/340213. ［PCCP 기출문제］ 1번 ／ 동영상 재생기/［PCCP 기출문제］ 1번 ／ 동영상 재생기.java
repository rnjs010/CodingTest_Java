class Solution {
    static int[] opS, opE;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] len = changeTime(video_len);
        int[] cur = changeTime(pos);
        opS = changeTime(op_start);
        opE = changeTime(op_end);
        
        if (checkOp(cur)) cur = opE.clone();
        
        for (String com : commands) {
            int min = cur[0];
            int sec = cur[1];
            if (com.equals("next")) {
                sec += 10;
                if (sec >= 60) {
                    min += 1;
                    sec -= 60;
                }
                if (min > len[0] || (min == len[0] && sec > len[1])) {
                    cur = len.clone();
                } else {
                    cur[0] = min;
                    cur[1] = sec;
                }
            } else {
                sec -= 10;
                if (sec < 0) {
                    min -= 1;
                    sec += 60;
                }
                if (min < 0) {
                    cur[0] = 0;
                    cur[1] = 0;
                } else {
                    cur[0] = min;
                    cur[1] = sec;
                }
            }
            
            if (checkOp(cur)) cur = opE.clone();
        }
        
        String answer = "";
        answer += String.format("%02d", cur[0]);
        answer += ":";
        answer += String.format("%02d", cur[1]);
        return answer;
    }
    
    static int[] changeTime(String time) {
        String[] str = time.split(":");
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            result[i] = Integer.parseInt(str[i]);
        }
        return result;
    }
    
    static boolean checkOp(int[] current) {
        if (current[0] > opS[0] && current[0] < opE[0]) {
            return true;
        } else if (current[0] == opS[0] && current[0] == opE[0]) {
            return (current[1] >= opS[1] && current[1] <= opE[1]) ? true : false;
        } else if (current[0] == opS[0]) {
            return (current[1] >= opS[1]) ? true : false;
        } else if (current[0] == opE[0]) {
            return (current[1] <= opE[1]) ? true : false;
        } else {
            return false;
        }
    }
}