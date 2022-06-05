import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ASum = 0;
        int BSum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ASum += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            BSum += Integer.parseInt(st.nextToken());
        }

        System.out.println(ASum - BSum);
    }
}