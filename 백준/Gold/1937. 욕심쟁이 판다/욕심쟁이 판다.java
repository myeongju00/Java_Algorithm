import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static int[][] board;
    static int[][] dp;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        dp = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);

    }
    static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        // dp 초기화
        dp[x][y] = 1;


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (board[x][y] < board[nx][ny]) {
                // 상하좌우 중에서 가장 오랫동안 생존할 수 있는 기간을 계산
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}