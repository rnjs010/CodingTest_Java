class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                isStart = true;
            } else {
                sb.append(isStart ? Character.toUpperCase(c) : Character.toLowerCase(c));
                isStart = false;
            }
        }
        return sb.toString();
    }
}
