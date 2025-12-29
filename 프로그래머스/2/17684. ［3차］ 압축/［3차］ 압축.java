import java.util.*;

class Solution {

    // Trie 노드 정의
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index;
    }

    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();

        // 1. Trie 초기화
        TrieNode root = new TrieNode();
        int nextIndex = 1;

        // 사전에 A~Z 등록
        for (char c = 'A'; c <= 'Z'; c++) {
            TrieNode node = new TrieNode();
            node.index = nextIndex++;
            root.children[c - 'A'] = node;
        }

        int i = 0;

        // 2. 메시지 탐색
        while (i < msg.length()) {
            TrieNode current = root;
            int lastIndex = 0;
            int j = i;

            // 사전에 존재하는 가장 긴 문자열 탐색
            while (j < msg.length()) {
                char c = msg.charAt(j);
                if (current.children[c - 'A'] == null) {
                    break;
                }
                current = current.children[c - 'A'];
                lastIndex = current.index;
                j++;
            }

            // 3. 가장 긴 문자열의 사전 번호 출력
            result.add(lastIndex);

            // 4. 새로운 문자열 (w + c) 사전에 추가
            if (j < msg.length()) {
                char nextChar = msg.charAt(j);
                TrieNode newNode = new TrieNode();
                newNode.index = nextIndex++;
                current.children[nextChar - 'A'] = newNode;
            }

            // 5. 처리한 만큼 인덱스 이동
            i = j;
        }

        // List → 배열 변환
        return result.stream().mapToInt(n -> n).toArray();
    }
}
