import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        Map<String, Integer> sub = new HashMap<>();
        Map<String, Integer> ans = new TreeMap<>();
        
        for (String str: records) {
            String[] record = str.split(" ");
            String[] time = record[0].split(":");
            String car = record[1];
            int minT = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            if (sub.containsKey(car)) {
                ans.put(car, ans.getOrDefault(car, 0) + (minT - sub.get(car)));
                sub.remove(car);
            } else {
                sub.put(car, minT);
            }
        }
        
        for (String key: sub.keySet()) {
            int plus = (23*60 + 59) - sub.get(key);
            ans.put(key, ans.getOrDefault(key, 0) + plus);
        }
        
        int[] answer = new int[ans.size()];
        int i = 0;
        for (String key: ans.keySet()) {
            int price = fees[1];
            int total = ans.get(key);
            if (total > fees[0]) {
                price += Math.ceil((double) (total - fees[0]) / fees[2]) * fees[3];
            }
            answer[i] = price;
            i++;
        }
        
        return answer;
    }
}