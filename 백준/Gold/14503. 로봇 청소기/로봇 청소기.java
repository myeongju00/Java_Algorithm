import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
    static int N, M, count = 1, r, c, d;
    static int[][] board;
    static int dx[] = {-1, 0, 1, 0};  // 북동남서
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); //방향

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r, c, d);
        System.out.println(count);
    }

    static void dfs(int x, int y, int dir) {
        board[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            dir -= 1;
            if (dir == -1) dir = 3;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (board[nx][ny] == 0) {
                    count++;
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4;
        int bx = x + dx[d];
        int by = y + dy[d];
        if (bx >= 0 && by >= 0 && bx < N && by < M && board[bx][by] != 1) {
            dfs(bx, by, dir);
        }
    }
}