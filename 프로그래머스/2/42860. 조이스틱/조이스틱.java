class Solution {
    public int solution(String name) {
        int answer = 0;
        int size = name.length();
        for (int i = 0; i < size; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int move = size - 1;
        for (int i = 0; i < size; i++) {
            int next = i + 1;
            while (next < size && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i * 2 + (size - next));
            move = Math.min(move, i + 2 * (size - next));
        }
        answer += move;     
        return answer;
    }
}