import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int answer = -1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            //단위
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            //목적지
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int end = lcm(M, N); // 최소공배수

            for (int i = x; i <= end; i += M) {
                if ((i - 1) % N + 1 == y) {
                    answer = i;
                    break;
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int lcm(int a, int b) {
        int tmpA = a, tmpB = b;
        while (tmpB != 0) {
            int temp = tmpB;
            tmpB = tmpA % tmpB;
            tmpA = temp;
        }
        return a * b / tmpA;
    }
}