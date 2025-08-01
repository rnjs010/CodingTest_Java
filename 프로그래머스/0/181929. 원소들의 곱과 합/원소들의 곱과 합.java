class Solution {
    public int solution(int[] num_list) {
        int a = 1, b = 0;
        
        for (int num : num_list) {
            a *= num;
            b += num;
        }
        
        int answer = (a < b*b) ? 1 : 0;
        return answer;
    }
}