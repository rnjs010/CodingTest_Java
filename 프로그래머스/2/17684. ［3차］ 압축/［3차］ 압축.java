import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }

        List<Integer> result = new ArrayList<>();
        int nextIndex = 27;

        StringBuilder w = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            w.append(msg.charAt(i));

            if (!dict.containsKey(w.toString())) {
                String prev = w.substring(0, w.length() - 1);
                result.add(dict.get(prev));

                dict.put(w.toString(), nextIndex++);

                w.setLength(0);
                w.append(msg.charAt(i));
            }
        }

        result.add(dict.get(w.toString()));
        return result.stream().mapToInt(i -> i).toArray();
    }
}
