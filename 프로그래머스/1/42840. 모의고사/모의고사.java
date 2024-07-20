import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> li = new ArrayList<>();
        
        int[] arr1 = {1, 2, 3, 4 , 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        int idx1 = 0, idx2 = 0, idx3 = 0;
        for (int ans : answers) {
            if (ans == arr1[idx1 % 5]) cnt1 += 1;
            if (ans == arr2[idx2 % 8]) cnt2 += 1;
            if (ans == arr3[idx3 % 10]) cnt3 += 1;
            idx1++;
            idx2++;
            idx3++;
        }
        
        int max_val = Math.max(cnt1, Math.max(cnt2, cnt3));
        if (max_val == cnt1) li.add(1);
        if (max_val == cnt2) li.add(2);
        if (max_val == cnt3) li.add(3);
        
        return li.stream().mapToInt(Integer::intValue).toArray();
    }
}