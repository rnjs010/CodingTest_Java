import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> ans = new HashSet<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                ans.add(numbers[i] + numbers[j]);
            }
        }
        
        return ans.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}