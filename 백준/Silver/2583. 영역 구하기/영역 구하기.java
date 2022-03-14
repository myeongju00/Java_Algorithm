import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //5
        N = Integer.parseInt(st.nextToken()); //7
        int K = Integer.parseInt(st.nextToken()); //3
        visited = new boolean[M][N];  // 5 7
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    visited[k][j] = true;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt = 0;
                    DFS(i, j);
                    answer.add(cnt);
                }
            }
        }
        System.out.println(answer.size());

        Collections.sort(answer);
        for(Integer i : answer) System.out.print(i + " ");
    }

    public  static void DFS(int x, int y) {
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx > M - 1 || ny > N - 1) {
                continue;
            }
            if (!visited[nx][ny]) {
                DFS(nx, ny);
            }
        }
    }
}