import java.util.*;

class Solution {

    private static final String ENTER_MSG = "님이 들어왔습니다.";
    private static final String LEAVE_MSG = "님이 나갔습니다.";

    private static class Log {
        String uid;
        String msg;

        Log(String uid, String msg) {
            this.uid = uid;
            this.msg = msg;
        }
    }

    public String[] solution(String[] record) {
        Map<String, String> nameMap = new HashMap<>();
        List<Log> logs = new ArrayList<>(record.length);

        for (String str : record) {
            String[] s = str.split(" ");

            switch (s[0]) {
                case "Enter":
                    nameMap.put(s[1], s[2]);
                    logs.add(new Log(s[1], ENTER_MSG));
                    break;

                case "Leave":
                    logs.add(new Log(s[1], LEAVE_MSG));
                    break;

                case "Change":
                    nameMap.put(s[1], s[2]);
                    break;
            }
        }

        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            Log log = logs.get(i);
            answer[i] = nameMap.get(log.uid) + log.msg;
        }

        return answer;
    }
}
