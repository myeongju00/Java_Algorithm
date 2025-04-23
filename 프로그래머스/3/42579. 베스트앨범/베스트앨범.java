import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();

        
        for(int i = 0; i < genres.length; i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }
        
        List<Integer> result = new ArrayList<>();
        //리스트로 변환 후 정렬 필요
        List<String> sortedGenres = new ArrayList<>(genresMap.keySet());
        sortedGenres.sort((a, b) -> genresMap.get(b) - genresMap.get(a));
        
        for(String genre : sortedGenres) {
            List<Song> list = songMap.get(genre);
            list.sort((a, b) -> {
                if(b.plays == a.plays) {
                    return a.id - b.id;
                }
                return b.plays - a.plays;
            });
            for (int i = 0; i < Math.min(2, list.size()); i++) {
                result.add(list.get(i).id);
            }
                
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public class Song {
        int id;
        int plays;

        public Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
}