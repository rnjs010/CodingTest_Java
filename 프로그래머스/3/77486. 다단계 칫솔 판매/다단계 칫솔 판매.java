// 첫 풀이 시간 초과 이유 (while문마다 객체 생성, 문자열 HashMap 접근 반복)
// -> 인덱스 기반으로 변경
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        
        Map<String, Integer> map = new HashMap<>();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(enroll[i], i);
            if (referral[i].equals("-")) parent[i] = -1;
            else parent[i] = map.get(referral[i]);
        }
        
        int[] answer = new int[n];
        for (int i = 0; i < seller.length; i++) {
            int cur = map.get(seller[i]);
            int money = amount[i] * 100;
            while (cur != -1 && money > 0) {
                int give = money / 10;
                answer[cur] += (money - give);
                money = give;
                cur = parent[cur];
            }
            
        }
        
        return answer;
    }
}