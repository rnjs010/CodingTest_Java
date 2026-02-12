import java.util.*;

class Solution {
    int row, col;
    List<Integer> candidate = new ArrayList<>();
    
    public int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        
        for (int i = 1; i < (1 << col); i++) {
            if (!minimality(i)) continue;
            
            if (uniqueness(relation, i)) {
                candidate.add(i);
            }
        }
        
        return candidate.size();
    }
    
    private boolean minimality(int bit) {
        for (int key: candidate) {
            if ((key & bit) == key) return false;
        }
        return true;
    }
    
    private boolean uniqueness(String[][] relation, int bit) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                if ((bit & (1 << j)) != 0) {
                    sb.append(relation[i][j]).append("|");
                }
            }
            set.add(sb.toString());
        }
        return set.size() == row;
    }
}
