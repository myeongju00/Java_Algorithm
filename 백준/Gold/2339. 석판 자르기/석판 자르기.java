import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = input(0, N, 0, N, -1);
        System.out.println(answer == 0 ? -1 : answer);
    }
    /**
     *
     * @param cut 0 : 가로, 1 : 세로
     * @return answer
     */
    public static int input(int startHeight, int endHeight, int startWidth, int endWidth, int cut) {
        int answer = 0;
        int voSuck = 0;
        int bollSoon = 0;
        for (int i = startHeight; i < endHeight; i++) {
            for (int j = startWidth; j < endWidth; j++) {
                if (board[i][j] == 1)
                    bollSoon++;
                else if (board[i][j] == 2)
                    voSuck++;
            }
        }

        if (voSuck == 0 || (voSuck == 1 && bollSoon >= 1) || (voSuck >=2 && bollSoon == 0)) {
            return 0;
        }
        else if (voSuck == 1 && bollSoon == 0) {
            return 1;
        }
        else {
            for (int i = startHeight; i < endHeight; i++) {
                for (int j = startWidth; j < endWidth; j++) {
                    if (board[i][j] == 1) {
                        if (cut != 0) {
                            boolean signal = true;
                            for (int k = startWidth; k < endWidth; k++) {
                                if (board[i][k] == 2) {
                                    signal = false;
                                    break;
                                }
                            }
                            if (signal) {
                                int first = input(startHeight, i, startWidth, endWidth, 0);
                                int second = input(i + 1, endHeight, startWidth, endWidth, 0);
                                answer += first * second;
                            }
                        }
                        if (cut != 1) {
                            boolean signal = true;
                            for (int k = startHeight; k < endHeight; k++) {
                                if (board[k][j] == 2) {
                                    signal = false;
                                    break;
                                }
                            }
                            if (signal) {
                                int first = input(startHeight, endHeight, startWidth, j, 1);
                                int second = input(startHeight, endHeight, j + 1, endWidth, 1);
                                answer += first * second;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}