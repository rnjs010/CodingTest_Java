// 중심에서 확장 O(N²)
// Manacher 알고리즘 있지만 복잡함 O(N)
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, expand(s, i, i));  // 홀수인 경우
            answer = Math.max(answer, expand(s, i, i + 1));  // 짝수인 경우
        }

        return answer;
    }
    
    public int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;  // 이미 반영이 되어서 조정 필요
    }
}