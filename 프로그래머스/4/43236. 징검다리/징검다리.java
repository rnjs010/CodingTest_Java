import java.io.*;
import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        int l = 1, r = distance;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            int pos = 0, cnt = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - pos < mid) {
                    cnt++;
                } else {
                    pos = rocks[i];
                }
            }
            
            if (distance - pos < mid) {
                cnt++;
            }
            
            if (cnt > n) {
                r = mid - 1;
            } else {
                answer = mid;
                l = mid + 1;
            }
        }
        
        return answer;
    }
}