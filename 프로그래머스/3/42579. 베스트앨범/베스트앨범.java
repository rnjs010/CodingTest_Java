import java.util.*;

class Solution {
    static class Song {
        int idx, play;

        Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.putIfAbsent(genres[i], new ArrayList<>());
            songMap.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<String> genreList = new ArrayList<>(totalMap.keySet());
        genreList.sort((a, b) -> totalMap.get(b) - totalMap.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : genreList) {
            List<Song> list = songMap.get(genre);
            list.sort((a, b) -> {
                if (b.play == a.play)
                    return a.idx - b.idx;
                return b.play - a.play;
            });

            for (int i = 0; i < Math.min(2, list.size()); i++) {
                result.add(list.get(i).idx);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}