import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();

        for (int bit = 1; bit < (1 << col); bit++) {
            if (!isMinimal(bit, candidateKeys)) continue;

            if (isUnique(bit, relation, row, col)) {
                candidateKeys.add(bit);
            }
        }

        return candidateKeys.size();
    }

    private boolean isMinimal(int bit, List<Integer> candidateKeys) {
        for (int key : candidateKeys) {
            if ((key & bit) == key) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(int bit, String[][] relation, int row, int col) {
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
