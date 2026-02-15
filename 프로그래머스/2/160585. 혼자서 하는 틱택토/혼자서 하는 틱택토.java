class Solution {
    public int solution(String[] board) {
        char[][] map = new char[3][3];
        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int oCnt = 0, xCnt = 0;
        for (char[] m: map) {
            for (char c: m) {
                if (c == 'O') oCnt++;
                else if (c == 'X') xCnt++;
            }
        }
        
        int answer = 1;
        if (oCnt < xCnt || oCnt > xCnt + 1) answer = 0;
        if (oCnt == xCnt && isWin(map, 'O')) answer = 0;
        if (oCnt == (xCnt + 1) && isWin(map, 'X')) answer = 0;
        return answer;
    }
    
    private boolean isWin(char[][] map, char c) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == c && map[i][1] == c && map[i][2] == c) {
                return true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == c && map[1][i] == c && map[2][i] == c) {
                return true;
            }
        }
        
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }
        
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {
            return true;
        }
        
        return false;
    }
}