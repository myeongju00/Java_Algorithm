import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        String str = bufferedReader.readLine();
        int answer = 0;
        int[] dp = new int[M];

        Arrays.fill(dp, 0);

        for (int i = 2; i < M; i++) {
            String temp = str.substring(i - 2, i + 1);
            if (temp.equals("IOI")) {
                dp[i] = dp[i - 2] + 1;
            }
            if (dp[i] >= N) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}