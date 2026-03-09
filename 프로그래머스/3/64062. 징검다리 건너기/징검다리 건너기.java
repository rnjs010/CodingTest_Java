class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int l = 1, r = 0;
        for (int s: stones) {
            r = Math.max(r, s);
        }
        
        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            boolean check = true;
            for (int s: stones) {
                if (s - mid < 0){ 
                    cnt++;
                    if (cnt >= k) {
                        check = false;
                        break;
                    }
                } else {
                    cnt = 0;
                }
            }
            
            if (check) {
                answer = Math.max(answer, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return answer;
    }
}