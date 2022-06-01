import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sub = n - m;

        if (sub == 1) {
            System.out.println(n);
        }
        else {
            BigInteger numerator = new BigInteger("1"); //분자
            BigInteger denominator = new BigInteger("1"); //분모

            for (int i = 0; i < sub; i++) {
                numerator = numerator.multiply(BigInteger.valueOf(n - i));
            }
            for (int i = sub; i > 0; i--) {
                denominator = denominator.multiply(BigInteger.valueOf(sub));
                sub--;
            }
            System.out.println(numerator.divide(denominator));

        }
    }
}