import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int n = 15746;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        if(N < 2) {
            System.out.println(dp[N]);
            return;
        }
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] % n )+ (dp[i - 1] % n);
        }

        System.out.println(dp[N] % n);
    }
}