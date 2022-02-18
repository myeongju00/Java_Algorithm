import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 1;
        int cnt = 1;
        for (int i = 0; i < N - 1; i++) {

            if (arr[i] <= arr[i + 1]) {
                cnt++;
            } else cnt = 1;
            max = Math.max(cnt, max);
        }
        int cnt1 = 1;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                cnt1++;
            } else cnt1 = 1;
            max = Math.max(cnt1, max);
        }
        sb.append(max).append("\n");
        System.out.print(sb);
    }
}
