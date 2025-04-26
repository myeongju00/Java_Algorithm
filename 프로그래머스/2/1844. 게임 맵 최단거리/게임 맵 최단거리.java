import java.util.*;
class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        // dfs(0, 0, 1, maps);
        bfs(maps);
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        return answer;
    }
    public void bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int depth = now[2];
            
            if(x == maps.length - 1 && y == maps[0].length - 1) {
                answer = Math.min(answer, depth);
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }
                if(!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, depth + 1});
                }
            }
        }
    }
    
    
    public void dfs(int x, int y, int depth, int[][] maps) {
        //0 : 벽 , 1 : 벽 X
        
        if(x == maps.length - 1 && y == maps[0].length - 1) {
            answer = Math.min(answer, depth);
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                continue;
            }
            if(!visited[nx][ny] && maps[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, maps);
                visited[nx][ny] = false;
            }
        }
    }
}