import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N, C;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 101]; // 달성고객 + 최대 도시고객
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken()); // 비용
            int customer = Integer.parseInt(st.nextToken()); // 고객
            for (int j = customer; j < C + 101; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - customer]);
            }
        }

        int ans = INF;
        for (int i = C; i < C + 101; i++) ans = Math.min(ans, dp[i]);
        System.out.println(ans);
    }
}