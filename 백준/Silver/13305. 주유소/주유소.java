import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static long[] cost;
    static long[] length;



    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        length = new long[N - 1];
        cost = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long min = cost[0];

        for (int i = 0; i < N - 1; i++) {
            if(cost[i] < min) {
                min = cost[i];
            }
            sum += min * length[i];
        }

        System.out.println(sum);
    }
}