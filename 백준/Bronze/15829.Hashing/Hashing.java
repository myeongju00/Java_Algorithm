import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

    public class Main {
        static int r = 31;
        static int MOD = 1234567891;

        public static void main(String[] args) throws IOException {
            //Hashing
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int l = Integer.parseInt(br.readLine());
            String str = br.readLine();
            long ans = 0;
            for (int i = 0; i < str.length(); i++) {
                long j = str.charAt(i) - 'a' + 1;
                for (int k = 0; k < i; k++) {
                    j *= r;
                    j %= MOD;
                }
                ans += j;
                ans %= MOD;
            }

            System.out.print(ans);
        }
    }
