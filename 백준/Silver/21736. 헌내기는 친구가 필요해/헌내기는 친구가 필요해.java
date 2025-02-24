import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    static String[][] board;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count, N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[N][M];
        visited = new boolean[N][M];

        //O는 빈 공간, X는 벽, I는 도연이, P는 사람
        int startX = 0;
        int startY = 0;

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) + "";
                if(board[i][j].equals("I")) {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY);
        if(count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        if(board[x][y].equals("P")) {
            count++;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > N - 1 || nx < 0 || ny > M - 1 || ny < 0) {
                continue;
            }

            if(board[nx][ny].equals("X")) {
                visited[nx][ny] = true;
                continue;
            }
            if(!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}