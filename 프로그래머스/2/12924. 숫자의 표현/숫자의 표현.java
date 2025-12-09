class Solution {
    public int solution(int n) {
        int answer = 0;
        int s = 1, e = 1;
        int sum = 1;

        while (s <= n) {
            if (sum == n) {
                answer++;
                sum -= s;
                s++;
            } 
            else if (sum < n) {
                e++;
                sum += e;
            } 
            else {
                sum -= s;
                s++;
            }
            if (e > n) break;
        }

        return answer;
    }
}
