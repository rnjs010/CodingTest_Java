import java.util.*;

class Solution {
    public Integer[] solution(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                ans.add(arr[i]);
            }
        }
        
        Integer[] answer = ans.toArray(new Integer[ans.size()]);
        return answer;
    }
}