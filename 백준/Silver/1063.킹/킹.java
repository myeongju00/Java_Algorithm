import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[8][8];
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0 ,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken(); // -1
        String stone = st.nextToken(); // -2
        int N = Integer.parseInt(st.nextToken());
        int kingX = 8-(king.charAt(1)-'0');
        int kingY = king.charAt(0)-65;
        int stoneX = 8-(stone.charAt(1)-'0');
        int stoneY = stone.charAt(0)-65;
        board[kingX][kingY] = -1;
        board[stoneX][stoneY] = -2;

        for (int i=0; i<N; i++) {
            String command = br.readLine();
            int nx,ny, num;
            switch (command) {
                case "LT":
                    num = 0;
                    break;
                case "T":
                    num = 1;
                    break;
                case "RT":
                    num = 2;
                    break;
                case "L":
                    num = 3;
                    break;
                case "R":
                    num = 4;
                    break;
                case "LB":
                    num = 5;
                    break;
                case "B":
                    num = 6;
                    break;
                default:
                    num = 7;
                    break;
            }
            nx = kingX + dx[num];
            ny = kingY + dy[num];
            if (nx < 0 || ny < 0 || nx > 7 || ny > 7) continue;

            if(board[nx][ny] == -2) { // 킹이 옮긴 곳이 돌이 있는 곳이라면 돌을 옮길 수 있는지 체크
                int sx = nx + dx[num];
                int sy = ny + dy[num];

                if (sx < 0 || sy < 0 || sx > 7 || sy > 7)  { // 돌이 넘어가는 경우 패스
                    continue;
                }
                board[kingX][kingY] = 0;
                board[nx][ny] = -1;
                board[sx][sy] = -2;
            }
            else {
                board[kingX][kingY] = 0;
                board[nx][ny] = -1;
            }
            kingX = nx;
            kingY = ny;
        }
        String answerKing = "";
        String answerStone ="";

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if(board[i][j] == -1) {
                    answerKing += (char)(65+j);
                    answerKing += (8-i);
                }
                else if (board[i][j] == -2) {
                    answerStone += (char)(65+j);
                    answerStone += (8-i);
                }
            }
        }
        System.out.println(answerKing);
        System.out.println(answerStone);
    }
}