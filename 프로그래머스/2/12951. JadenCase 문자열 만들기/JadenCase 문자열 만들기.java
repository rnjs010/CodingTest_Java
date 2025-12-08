class Solution {
  public String solution(String s) {
        String answer = "";
        String[] str = s.toLowerCase().split("");
        boolean isStart = true;

        for(String ss : str) {
            answer += isStart ? ss.toUpperCase() : ss;
            isStart = ss.equals(" ") ? true : false;
        }

        return answer;
  }
}