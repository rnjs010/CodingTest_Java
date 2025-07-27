import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (li.size() == k) {
                break;
            }
            if (li.contains(arr[i])) {
                continue;
            }
            li.add(arr[i]);
        }
        
        for (int i = 0; i < li.size(); i++) {
            answer[i] = li.get(i);
        }
        return answer;
    }
}