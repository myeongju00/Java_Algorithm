import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] W;
    static boolean[] visited;
    static int N, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int now, int sum, int cnt) {
        if(cnt == N-1) {
            if(W[now][start] != 0) {
                sum += W[now][start];
                answer = Math.min(answer, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i] && W[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, sum + W[now][i], cnt + 1);
                visited[i] = false;
            }
        }
    }
}
