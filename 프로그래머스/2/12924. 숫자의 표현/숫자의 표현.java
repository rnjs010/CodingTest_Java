class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int s = 1, e = 2;
        while (s < e && s <= n/2) {
            int k = e - s + 1;
            int sum = (k * s) + (k * (k - 1)) / 2;
            if (sum < n) e++;
            else if (sum > n) s++;
            else {
                answer++;
                s++;
            }
        }
        
        return answer;
    }
}