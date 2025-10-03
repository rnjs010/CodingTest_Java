class Solution {
    static int r;
    static int[] discount;
    static int[] arr = {10, 20, 30, 40};
    static int[][] u;
    static int[] emo;
    static int maxP = 0, maxM = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        r = emoticons.length;
        discount = new int[r];
        u = users;
        emo = emoticons;
        
        perm(0);
        int[] answer = {maxP, maxM};
        return answer;
    }
    
    static void perm(int d) {
        if (d == r) {
            res(discount);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            discount[d] = arr[i];
            perm(d + 1);
        }
    }
    
    static void res(int[] dis) {
        int[] cost = new int[r];
        for (int i = 0; i < r; i++) {
            cost[i] = emo[i] * (100 - dis[i]) / 100;
        }
        
        int plus = 0;
        int money = 0;
        for (int i = 0; i < u.length; i++) {
            int buy = 0;
            for (int j = 0; j < r; j++) {
                if (u[i][0] <= dis[j]) {
                    buy += cost[j];
                }
            }
            if (buy >= u[i][1]) plus++;
            else money += buy;
        }
        
        if (plus > maxP) {
            maxP = plus;
            maxM = money;
        } else if (plus == maxP && money > maxM) {
            maxM = money;
        }
    }
}