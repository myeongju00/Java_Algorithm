import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        DP = new int [12];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for (int i = 4; i < 12; i++) {
            DP[i] = DP[i-3] + DP[i-2] + DP[i-1];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(DP[n]).append("\n");
        }
        System.out.println(sb);
    }
}