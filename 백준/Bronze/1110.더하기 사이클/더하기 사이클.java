import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        int n = N;

        while (true) {
            n = ((n % 10) * 10) + (((n / 10) + ( n % 10)) % 10);
            cnt++;
            if (N == n) {
                break;
            }
        }
        sb.append(cnt).append("\n");
        System.out.println(sb);
    }
}