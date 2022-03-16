import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int cnt = 0;
    static boolean[] visited = new boolean[1000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int [5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String ans = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, ans);
            }
        }
        for (boolean b : visited) {
            if (b) cnt++;
        }
        System.out.println(cnt);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static void dfs(int x, int y, int depth, String ans) {
        if(depth == 6) {
            visited[Integer.parseInt(ans)] = true;
            return;
        }
        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > 4 || ny > 4) {
                continue;
            }
            dfs(nx, ny, depth + 1, ans + board[x][y]);

        }
    }
}