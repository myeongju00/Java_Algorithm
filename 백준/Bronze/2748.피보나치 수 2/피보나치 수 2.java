import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fibonacci(N);
        System.out.print(sb);
    }
    static void fibonacci(int N) {
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");

        if(N == 0) sb.append(0).append("\n");
        else if(N == 1) sb.append(1).append("\n");
        else { //N >= 2
            for (int i = 2; i <= N; i++) {
                BigInteger temp = second;
                second = second.add(first);
                first = temp;
            }
            sb.append(second).append("\n");
        }

    }
}
