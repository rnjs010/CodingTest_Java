/*
  사용 알고리즘 : 플로이드 워셜
  1) A가 B를 이기고, B가 C를 이기면, A는 C를 이긴다 = 간접 관계를 전부 알아야 함
     -> 모든 노드 쌍의 관계 (2차원 배열 필요), 중간 노드 (경유지 k)
  2) n이 작음 = O(N³) 가능
  
  DFS도 가능 (이기고 지는 graph 2개 만들어야 함)
*/

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int[] res: results) {
            map[res[0]][res[1]] = true;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][k] && map[k][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] || map[j][i]) cnt++;
            }
            if (cnt == (n - 1)) answer++;
        }
        
        return answer;
    }
}