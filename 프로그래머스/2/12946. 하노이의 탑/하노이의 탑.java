import java.util.*;

class Solution {
    List<int[]> res = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
    
    public void hanoi(int n, int s, int e, int m) {
        if (n == 1) {
            res.add(new int[] {s, e});
            return;
        }
        
        hanoi(n - 1, s, m, e);
        res.add(new int[] {s, e});
        hanoi(n - 1, m, e, s);
    }
}