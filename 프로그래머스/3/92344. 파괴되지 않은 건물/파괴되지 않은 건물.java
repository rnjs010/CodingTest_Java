/*
  ⭐누적합(Prefix Sum) + 차분 배열(Diffrence Array)⭐
  *차분 배열 : 어디서 시작하고, 어디서 끝나는지만 기록
  diff[r1][c1] += k;
  diff[r1][c2+1] -= k;
  diff[r2+1][c1] -= k;
  diff[r2+1][c2+1] += k; (중복되는 구간 보정)
  
  ex) 3x3 보드의 (0,0) ~ (1,1) 영역에 +5
  diff (4x4) 차분 배열에 4군데 찍기
   [ 5  0 -5  0
     0  0  0  0
    -5  0  5  0
     0  0  0  0]
      
  가로 누적합 결과
  [ 5  5  0  0
    0  0  0  0
   -5 -5  0  0
    0  0  0  0]
    
  세로 누적합 결과
  [ 5  5  0  0
    5  5  0  0
    0  0  0  0
    0  0  0  0]
*/

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        // diff 배열 생성
        int[][] diff = new int[n + 1][m + 1];
        
        // 차분 적용 (변화의 경계만 기록)
        for (int[] s: skill) {
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int deg = s[5];
            if (s[0] == 1) deg = -deg;
            
            diff[r1][c1] += deg;
            diff[r1][c2 + 1] -= deg;
            diff[r2 + 1][c1] -= deg;
            diff[r2 + 1][c2 + 1] += deg;
        }
        
        // 가로 누적합 (퍼뜨리기)
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        
        // 세로 누적합
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        // board에 적용
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += diff[i][j];
                if (board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}