import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[][] B = new int[H + X][W + Y];

        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] A = new int[H][W];

        for (int i = 0; i < H + X; i++) {
            for (int j = 0; j < W + Y; j++) {
                if(i >= X && j >= Y && i < H && j < W) {
                    A[i][j] = B[i][j] - A[i-X][j-Y];
                }
                else if (i < H && j < W) A[i][j] = B[i][j];
            }
        }

        for(int[] mj : A){
            for (int mjmj : mj) sb.append(mjmj).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);

    }

}
