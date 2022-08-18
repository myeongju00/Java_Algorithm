import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static char[][] board;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int R, C, wolf, sheep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j] == 'o')  {
                    sheep++;
                } else if (board[i][j] == 'v') {
                    wolf++;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) continue;
                if (board[i][j] == 'o' || board[i][j] == 'v') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(int i, int j) {
        int curWolf = 0, curSheep = 0;

        queue.add(new int[] {i, j});
        visited[i][j] = true;
        if(board[i][j] == 'o') curSheep++;
        else if (board[i][j] == 'v') curWolf++;

        while (!queue.isEmpty()) {
            int [] point = queue.remove();
            int x = point[0];
            int y = point[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if(visited[nx][ny] || board[nx][ny] == '#') continue;
                    if(board[nx][ny] == 'o') {
                        curSheep++;
                    } else if (board[nx][ny] == 'v') {
                        curWolf++;
                    }
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        if(curSheep > curWolf) {
            wolf -= curWolf;
        } else sheep -= curSheep;
    }


}
