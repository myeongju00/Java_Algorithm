import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

    public class Main {

        public static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            sb.append((int) (Math.pow(2, N) - 1)).append('\n');

            Hanoi(N, 1, 2, 3);
            System.out.println(sb);

        }

        public static void Hanoi(int N, int start, int mid, int to) {
            if (N == 1) {
                sb.append(start + " " + to + "\n");
                return;
            }

            // A -> C
            //N-1개를 A-> B (= start 지점의 N-1개의 원판을 mid 지점으로)
            Hanoi(N - 1, start, to, mid);

            //1개를 A -> C
            sb.append(start + " " + to + "\n");

            //N-1개를 B -> C (= mid 지점의 N-1개의 원판을 to 지점으로)
            Hanoi(N - 1, mid, start, to);
        }
    }
