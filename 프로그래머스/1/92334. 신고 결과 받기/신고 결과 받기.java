import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        Map<String, Integer> reportCnt = new HashMap<>();
        Map<String, List<String>> reportFrom = new HashMap<>();
        Map<String, Integer> ansMap = new LinkedHashMap<>();
        for (String str: id_list) {
            reportCnt.put(str, 0);
            reportFrom.put(str, new ArrayList<>());
            ansMap.put(str, 0);
        }
        
        for (String str: reportSet) {
            String[] s = str.split(" ");
            String reporter = s[0];
            String reported = s[1];
            
            reportCnt.put(reported, reportCnt.get(reported) + 1);
            reportFrom.get(reported).add(reporter);
        }
        
        for (int i = 0; i < id_list.length; i++) {
            if (reportCnt.get(id_list[i]) >= k) {
                for (String str: reportFrom.get(id_list[i])) {
                    ansMap.put(str, ansMap.get(str) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        List<Integer> ans = new ArrayList<>(ansMap.values());
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = ans.get(i);
        }
        
        
        return answer;
    }
}