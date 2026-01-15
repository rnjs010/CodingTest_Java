class Solution {
    public int solution(int[] arrayA, int[] arrayB) { 
        int a = arrayA[0];
        int b = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }
        
        boolean chkA = true, chkB = true;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayB[i] % a == 0) chkA = false;
            if (arrayA[i] % b == 0) chkB = false;
        }
        
        int answer = 0;
        if (chkA && chkB) {
            answer = Math.max(a, b);
        } else if (chkA) {
            answer = a;
        } else if (chkB) {
            answer = b;
        }
        
        return answer;
    }
    
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}