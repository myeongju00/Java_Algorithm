import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;  // N: 행, M: 열
    static int[][] map;  // 테트로미노 판
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행과 열의 크기 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 테트로미노 판 크기 N x M 생성
        map = new int[N][M];
        visited = new boolean[N][M];

        // 테트로미노 값 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(i, j, 0, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int depth, int sum) {
        if(depth == 3) {
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                continue;
            }
            if(!visited[nx][ny]) {
                if(depth == 1) {
                    visited[nx][ny] = true;
                    dfs(x, y, depth + 1, sum + map[nx][ny]);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
}