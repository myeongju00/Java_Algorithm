import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N];
        Arrays.fill(DP, -1);
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = 0;
        for (int i = 0; i < N - 1; i++) {
            if(DP[i] == -1) {
                continue;
            }
            for (int j = 1; j <= arr[i]; j++) {
                if(i + j < N) {
                    if (DP[i + j] == -1 || DP[i + j] > DP[i] + 1) {
                        DP[i + j] = DP[i] + 1;
                    }
                }
            }
        }
        System.out.println(DP[N - 1]);
    }
}