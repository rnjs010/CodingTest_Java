/*
  요약 : 2차원 점수에서 "둘 다 낮으면 탈락"이라는 지배 관계를 처리하는 문제
  잘못된 접근 : 투포인터 (정렬하고 양쪽에서 비교하려고 함)
  but, 단순 비교가 아니라 2차원 지배 관계, 상태 유지가 안 됨
  
  해결 방법 : 정렬 + 한 방향 스캔 (그리디?)
  point = 첫 점수 ↓, 같으면 두 번째 점수 ↑ (첫 점수는 이미 큰 순서, 같은 첫 점수끼리는 안전하게 처리됨)
  *앞에 이미 더 큰 first 존재, second까지 작으면 완전히 밀림
*/
import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0];
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int maxSec = 0;
        int answer = 1;
        for (int[] s: scores) {
            if (s[0] > target[0] && s[1] > target[1]) return -1;  // 완호 탈락
            
            if (s[1] < maxSec) continue;  // 다른 사람 탈락
            
            maxSec = Math.max(maxSec, s[1]);
            if (s[0] + s[1] > target[0] + target[1]) {  // 등수 갱신
                answer++;
            }
        }
        
        return answer;
    }
}