import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int idx, cnt;
        
        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Node o) {
            if (o.cnt == this.cnt) return Integer.compare(this.idx, o.idx);
            return Integer.compare(o.cnt, this.cnt);
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCnt = new HashMap<>();
        Map<String, PriorityQueue<Node>> music = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0) + plays[i]);
            music.putIfAbsent(genres[i], new PriorityQueue<>());
            music.get(genres[i]).add(new Node(i, plays[i]));
        }
        
        List<String> genreList = new ArrayList<>(genreCnt.keySet());
        genreList.sort((a, b) -> (genreCnt.get(b) - genreCnt.get(a)));
        
        List<Integer> result = new ArrayList<>();
        for (String g: genreList) {
            PriorityQueue<Node> pq = music.get(g);
            int count = 0;
            while (!pq.isEmpty() && count < 2) {
                result.add(pq.poll().idx);
                count++;
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}