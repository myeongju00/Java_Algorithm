import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char [8][8];
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++){
                if(i % 2 == 0) {
                    if(board[i][j] == 'F') cnt++;
                    j++;
                } else {
                    if(j % 2 == 1) {
                        if(board[i][j] == 'F') cnt++;
                        j++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}