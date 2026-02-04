import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> nums = new ArrayList<>();
        nums.add(k);
        while(k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            nums.add(k);
        }
        
        int n = nums.size() - 1;
        double[] preSum = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            double sum = (double) (nums.get(i - 1) + nums.get(i)) / 2;
            preSum[i] = preSum[i - 1] + sum;
        }
        
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] > n + ranges[i][1]) {
                answer[i] = -1;
                continue;
            }
            answer[i] = preSum[n + ranges[i][1]] - preSum[ranges[i][0]];
        }
        return answer;
    }
}