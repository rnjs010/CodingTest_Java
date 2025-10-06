import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int tDate = toDays(today);

        // 약관 기간 저장
        Map<String, Integer> term = new HashMap<>();
        for (String str : terms) {
            String[] s = str.split(" ");
            term.put(s[0], Integer.parseInt(s[1]));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            int start = toDays(s[0]);
            int expire = start + term.get(s[1]) * 28; // 한 달 = 28일 기준

            if (expire <= tDate) ans.add(i + 1);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // 날짜를 "YYYY.MM.DD" → 총 일수로 변환
    static int toDays(String date) {
        String[] str = date.split("\\.");
        int y = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int d = Integer.parseInt(str[2]);
        return (y * 12 * 28) + (m * 28) + d;
    }
}
