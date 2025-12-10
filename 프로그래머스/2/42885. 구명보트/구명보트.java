import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int l = 0, r = people.length - 1;
        
        Arrays.sort(people);
        while (l <= r) {
            int sum = people[l] + people[r];
            if (sum <= limit) {
                l++;
            }
            r--;
            answer++;
        }
        
        return answer;
    }
}