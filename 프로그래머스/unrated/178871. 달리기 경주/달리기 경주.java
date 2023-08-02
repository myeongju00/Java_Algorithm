import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> rank = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        for(String call : callings) {
            int Playerrank = rank.get(call);
            
            String frontPlayer = players[Playerrank - 1];
            
            players[Playerrank - 1] = call;
            players[Playerrank] = frontPlayer;
            
            rank.put(call, Playerrank - 1);
            rank.put(frontPlayer, Playerrank);
        }
        
        return players;
    }
}