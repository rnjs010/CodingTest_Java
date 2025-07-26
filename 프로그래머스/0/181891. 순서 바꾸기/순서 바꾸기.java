import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int[] arr1 = Arrays.copyOfRange(num_list, 0, n);
        int[] arr2 = Arrays.copyOfRange(num_list, n, num_list.length);
        
        for (int i = 0; i < arr2.length; i++) {
            answer[i] = arr2[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            answer[i + arr2.length] = arr1[i];
        }
        
        return answer;
    }
}