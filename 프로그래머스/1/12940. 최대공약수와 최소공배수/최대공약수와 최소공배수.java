class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[] {gcd(n, m), lcm(n, m)};
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    public int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}