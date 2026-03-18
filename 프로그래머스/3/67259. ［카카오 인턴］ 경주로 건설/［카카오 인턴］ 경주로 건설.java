import java.util.*;

class Solution {
    static class Node {
        int x, y, dir, cost;
        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.cost - b.cost
        );
        
        cost[0][0][0] = 0;
        pq.offer(new Node(0, 0, -1, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] == 1) continue;
                if (cost[nx][ny][d] < cur.cost) continue;
                
                int newCost = cur.cost;
                if (cur.dir == -1 || cur.dir == d) {
                    newCost += 100;
                } else {
                    newCost += 600;
                }
                
                if (cost[nx][ny][d] > newCost) {
                    cost[nx][ny][d] = newCost;
                    pq.offer(new Node(nx, ny, d, newCost));
                }
                
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int c: cost[n - 1][n - 1]) {
            answer = Math.min(answer, c);
        }
        return answer;
    }
}