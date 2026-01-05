class Solution {
    public int[] solution(int[] sequence, int k) {
        int s = 0, e = 0;
        long sum = sequence[0];
        int minL = sequence.length + 1, ansS = 0, ansE = 0;
        while (s <= e) {
            if (sum == k) {
                int len = e - s + 1;
                if (len < minL) {
                    minL = len;
                    ansS = s;
                    ansE = e;
                }
                sum -= sequence[s];
                s++;
            } else if (sum > k) {
                sum -= sequence[s];
                s++;
                continue;
            }
            
            e++;
            if (e >= sequence.length) break;
            sum += sequence[e];
        }
        
        int[] answer = new int[] {ansS, ansE};
        return answer;
    }
}