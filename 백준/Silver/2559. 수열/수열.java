import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += arr[i];
        }

        int max = sum;
        for (int i = K + 1, j = 1; i <= N; i++, j++) {
            sum += arr[i] - arr[j];
            if (max < sum) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}