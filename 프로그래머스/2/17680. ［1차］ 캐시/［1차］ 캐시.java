import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;

        Map<String, String> cache = new LinkedHashMap<String, String>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > cacheSize;
            }
        };

        for (String c : cities) {
            String city = c.toLowerCase();

            if (cache.containsKey(city)) {
                answer += 1;
            } else {
                answer += 5;
            }
            cache.put(city, city);
        }

        return answer;
    }
}
