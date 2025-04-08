import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        board = new char[N][N];

        int maxCandies = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            board[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 좌우
                if( j < N - 1) {
                    swap(i, j, i, j + 1);
                    maxCandies = Math.max(maxCandies, countCandies());
                    swap(i, j, i, j + 1);
                }

                // 상하
                if(i < N - 1) {
                    swap(i, j, i + 1, j);
                    maxCandies = Math.max(maxCandies, countCandies());
                    swap(i, j, i + 1, j);
                }

            }
        }
        System.out.println(maxCandies);
    }
    public static void swap(int x, int y, int nx, int ny) {
        char temp = board[x][y];
        board[x][y] = board[nx][ny];
        board[nx][ny] = temp;
    }

    //최대 사탕 개수 구하는 메서드
    public static int countCandies() {
        int maxLen = 0;
        for(int i = 0; i < N; i++) {
            int rowCnt = 1;
            int colCnt = 1;

            for(int j = 1; j < N; j++) {
                if(board[i][j] == board[i][j - 1]) {
                    rowCnt++;
                } else {
                    maxLen = Math.max(maxLen, rowCnt);
                    rowCnt = 1;
                }

                if (board[j][i] == board[j - 1][i]) {
                    colCnt++;
                } else {
                    maxLen = Math.max(maxLen, colCnt);
                    colCnt = 1;
                }
            }
            maxLen = Math.max(maxLen, rowCnt);
            maxLen = Math.max(maxLen, colCnt);
        }
        return maxLen;
    }
}
