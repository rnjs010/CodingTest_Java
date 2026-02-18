class Solution {
    int[] answer = new int[11];
    int[] temp = new int[11];
    int diff = 0;
    int[] info;
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        dfs(0, n);
        if (diff == 0) return new int[] {-1};
        return answer;
    }
    
    private void dfs(int idx, int left) {
        if (idx == 11) {
            if (left > 0) temp[10] += left;
            result();
            if (left > 0) temp[10] -= left;
            return;
        }
        
        int next = info[idx] + 1;
        if (next <= left) {
            temp[idx] = next;
            dfs(idx + 1, left - next);
            temp[idx] = 0;
        }
        dfs(idx + 1, left);
    }
    
    private boolean result() {
        int aT = 0, lT = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && temp[i] == 0) {
                continue;
            } else if (info[i] >= temp[i]) {
                aT += (10 - i);
            } else if (info[i] < temp[i]) {
                lT += (10 - i);
            }
        }
        
        if (aT >= lT) return false;
        int d = lT - aT;
        if (d > diff) {
            diff = d;
            answer = temp.clone();
        } else if (d == diff) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] == temp[i]) continue;
                if (answer[i] < temp[i]) {
                    answer = temp.clone();
                }
                break;
            }
        }
        return true;
    }
}