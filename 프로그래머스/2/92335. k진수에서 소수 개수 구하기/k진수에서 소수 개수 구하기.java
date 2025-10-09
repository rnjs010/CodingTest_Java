class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String convert = sb.reverse().toString();
        
        String[] parts = convert.split("0");
        
        int answer = 0;
        for (String s: parts) {
            if (s.isEmpty()) continue;
            if (isPrime(Long.parseLong(s))) answer++;
        }
        
        return answer;
    }
    
    static Boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}