import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
    }
    public static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        if(row == 9) {
            boardToString();
            System.exit(0);
        }

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checkingNumber(row, col, i)) {
                    board[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }
        dfs(row, col + 1);
    }

    private static void boardToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean checkingNumber(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if(board[i][col] == value) {
                return false;
            }
        }

        /** 3 * 3 박스 체크 */
        int rowIndex = (row / 3) * 3;
        int colIndex = (col / 3) * 3;

        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = colIndex; j < colIndex + 3; j++) {
                if(board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}