class Solution {
    public long solution(int w, int h) {
        long g = gcd(w, h);
        long remove = ((w / g) + (h / g) - 1) * g;    
        long answer = (long) w * h - remove;
        return answer;
    }
    
    private long gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}