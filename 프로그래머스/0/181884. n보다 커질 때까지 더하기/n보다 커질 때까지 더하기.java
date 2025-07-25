class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for (int nums: numbers) {
            answer += nums;
            if (answer > n) break;
        }
        return answer;
    }
}