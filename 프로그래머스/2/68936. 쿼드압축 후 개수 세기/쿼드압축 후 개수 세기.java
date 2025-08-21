class Solution {
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        func(arr[0].length, 0, 0, arr);
        return answer;
    }
    
    public void func(int n, int r, int c, int[][] arr) {
        if (n == 1) {
            answer[arr[r][c]] += 1;
            return;
        }
        
        boolean chk = true;
        int num = arr[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (num != arr[i][j]) {
                    chk = false;
                    break;
                }
            }
        }
        
        int half = n / 2;
        if (chk) {
            answer[num] += 1;
            return;
        } else {
            func(n/2, r, c, arr);
            func(n/2, r, c + half, arr);
            func(n/2, r + half, c, arr);
            func(n/2, r + half, c + half, arr);
        }
    }
}