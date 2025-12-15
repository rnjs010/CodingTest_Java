import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        List<Integer> li = new ArrayList<>();
        for (int c : citations) {
            li.add(c);
        }

        Collections.sort(li, Collections.reverseOrder());
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i) >= i + 1) {
                answer = i + 1;
            }
        }

        return answer;
    }
}
