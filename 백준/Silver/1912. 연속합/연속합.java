import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        int [] DP = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DP[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < N; i++) {
            DP[i] = Math.max(DP[i - 1] + arr[i], arr[i]);
            max = Math.max(max, DP[i]);
        }

        System.out.println(max);
    }
}