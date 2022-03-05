import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            BigInteger K = new BigInteger(br.readLine());

            if (K.remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
                sb.append("even").append("\n");
            } else {
                sb.append("odd").append("\n");
            }
        }
        System.out.println(sb);
    }
}