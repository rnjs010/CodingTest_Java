class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] right = new int[n];        
        right[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], a[i]);
        }
        
        int answer = 0;
        int left = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            left = Math.min(left, a[i]);
            
            if (left >= a[i] || right[i] >= a[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}