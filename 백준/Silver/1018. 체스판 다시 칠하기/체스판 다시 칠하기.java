import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }

            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }

        sb.append(min).append("\n");
        System.out.println(sb);
    }

    public static void find(int x, int y) {
        int end_X = x + 8;
        int end_Y = y + 8;
        int count = 0;

        boolean WB = arr[x][y];
        for(int i = x; i < end_X; i++) {
            for(int j = y; j < end_Y; j++) {
                if(arr[i][j] != WB) {
                    count++;
                }
                WB = !WB;
            }
            WB = !WB;
        }
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}