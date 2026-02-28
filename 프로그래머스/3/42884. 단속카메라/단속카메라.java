import java.util.*;

class Solution {
    public int solution(int[][] routes) {        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int val = -30001;
        int answer = 0;
        for (int i = 0; i < routes.length; i++) {
            if (val >= routes[i][0]) {
                continue;
            } else {
                val = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}