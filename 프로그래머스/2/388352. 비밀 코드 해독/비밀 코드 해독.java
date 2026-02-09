class Solution {
    int[] arr = new int[5];
    int nn, answer;
    int[][] qq;
    int[] res;
    
    public int solution(int n, int[][] q, int[] ans) {
        nn = n;
        qq = q;
        res = ans;
        answer = 0;
        
        comb(0, 1);
        return answer;
    }
    
    private void comb(int depth, int start) {
        if (depth == 5) {
            if (check()) answer++;
            return;
        }
        
        for (int i = start; i <= nn; i++) {
            arr[depth] = i;
            comb(depth + 1, i + 1);
        }
    }
    
    private boolean check() {
        for (int i = 0; i < qq.length; i++) {
            int cnt = 0;
            for (int a: arr) {
                for (int b: qq[i]) {
                    if (a == b) cnt++;
                }
            }
            
            if (cnt != res[i]) return false;
        }
        return true;
    }
}