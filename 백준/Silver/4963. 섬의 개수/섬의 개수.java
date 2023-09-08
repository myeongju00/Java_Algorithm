import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int w, h;
    static boolean[][] visited;
    static int[][] board;
    static ArrayList<ArrayList<Integer>> graph;

    static int[] dx = new int[] {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = new int[] {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) {
                break;
            }

            board = new int[h][w];
            visited = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && board[i][j] == 1) {
                        dfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);

        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextX < w && nextY < h) {
                if(!visited[nextY][nextX] && board[nextY][nextX] == 1) {
                    dfs(nextY, nextX);
                }
            }
        }
    }


}