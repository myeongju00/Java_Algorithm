import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] board;
    static boolean[] visited;
    static int N;
    static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(Min);
    }

    public static void dfs(int idx, int depth) {
        if(depth == N / 2) {
            int team_start = 0;
            int team_link = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    // i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
                    if (visited[i] && visited[j]) {
                        team_start += board[i][j];
                        team_start += board[j][i];
                    }
                    // i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
                    else if (!visited[i] && !visited[j]) {
                        team_link += board[i][j];
                        team_link += board[j][i];
                    }
                }
            }

            // 두 팀의 점수 차이 (절댓값)
            int val = Math.abs(team_start - team_link);

            /*
              두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
              더이상의 탐색 필요없이 0을 출력하고 종료
             */

            if (val == 0) {
                System.out.println(val);
                System.exit(0);
            }

            Min = Math.min(val, Min);
            return;
        }

        for (int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}