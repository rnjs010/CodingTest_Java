import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int c = col - 1;
        row_begin--;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[c] != o2[c]) {
                return Integer.compare(o1[c], o2[c]);
            }
            return Integer.compare(o2[0], o1[0]);
        });
        
        int answer = 0;
        for (int i = row_begin; i < row_end; i++) {
            int sum = 0;
            for (int num: data[i]) {
                sum += num % (i + 1);
            }
            answer ^= sum;
        }
        
        return answer;
    }
}