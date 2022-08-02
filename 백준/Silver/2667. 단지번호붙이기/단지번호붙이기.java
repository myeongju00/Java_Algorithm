import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N;
    static int apartNum = 0;
    static int[] result;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = new int [] {0, 0, 1, -1};
    static int[] dy = new int [] {1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        visited = new boolean[N][N];
        result = new int[N * N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    dfs(i, j);
                }
            }
        }
        sb.append(apartNum).append("\n");

        Arrays.sort(result);
        for(int i : result) {
            if(i != 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        result[apartNum]++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(board[nx][ny] == 1 && !visited[nx][ny] ) {
                dfs(nx, ny);
            }
        }
    }

}