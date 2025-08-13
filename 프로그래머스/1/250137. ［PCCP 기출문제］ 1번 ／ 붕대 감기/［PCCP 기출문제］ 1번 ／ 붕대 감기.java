class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int power = health;
        
        for (int i = 0; i < attacks.length; i++) {
            int can = attacks[i][0] - time - 1;
            power += (can * bandage[1]);
            if (can >= bandage[0]) {
                power += (can / bandage[0] * bandage[2]);
            }
            if (power > health) power = health;
            power -= attacks[i][1];
            time = attacks[i][0];
            if (power <= 0) break;
        }
        
        
        int answer = (power > 0) ? power : -1;
        return answer;
    }
}