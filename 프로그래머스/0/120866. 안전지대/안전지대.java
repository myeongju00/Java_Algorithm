import java.util.*;
class Solution {
    int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public int solution(int[][] board) {
        int answer = 0;
        List<int[]> bombs = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 1) {
                    bombs.add(new int[] {i, j});
                    
                }
            }
        }
        for(int[] bomb : bombs) {
            boom(bomb[0], bomb[1], board);
        }
        System.out.println(Arrays.deepToString(board));
        for(int[] list : board) {
            for(int i : list) {
                if(i == 0) {
                    answer++;
                } 
            }
        }
        return answer;
    }
    
    public void boom(int x, int y, int[][] board) {
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) {
                continue;
            }
            board[nx][ny] = 1;
        }
    }
}