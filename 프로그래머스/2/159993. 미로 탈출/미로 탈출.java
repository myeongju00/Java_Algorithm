import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static String[][] board;
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    public int solution(String[] maps) {
        board = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] labor = new int[2];

        for(int i = 0; i < maps.length; i++) {
            board[i] = maps[i].split("");

            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals("S")) {
                    start = new int[]{i, j};
                }
                if(board[i][j].equals("L")) {
                    labor = new int[]{i, j};
                }
            }
        }
        int result = bfs(start, "L");
        int result2 = bfs(labor, "E");

        if (result == -1 || result2 == -1) {
            return -1;
        }

        return result + result2;
    }

    public int bfs(int[] start, String target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});

        boolean[][] visited = new boolean[board.length][board[0].length];

        while (!queue.isEmpty()) {
            int[] point = queue.peek();
            int x = point[0];
            int y = point[1];
            int cnt = point[2];
            visited[x][y] = true;

            if(board[x][y].equals(target)) {
                return cnt;
            }

            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !visited[nx][ny]) {
                    if (!board[nx][ny].equals("X")) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }
}