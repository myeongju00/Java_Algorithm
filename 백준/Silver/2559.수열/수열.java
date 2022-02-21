import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N - K + 1; i++) {
            int sum = 0;
            for (int j = i; j < K + i; j++) {
                sum += arr[j];
            }
            result = Math.max(sum, result);
        }
        sb.append(result).append("\n");
        System.out.println(sb);
    }
}