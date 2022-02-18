import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());

            int cnt = 0;
            if( N == 0) break;

            make_prime(N);

            for (int i = N + 1; i <= 2 * N; i ++) {
                if (!prime[i]) { //false
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void make_prime(int N) {
        prime = new boolean[2 * N + 1]; //0 부터 2 * N 까지
        //소수 : false, 소수 X :true
        if(N < 2) return;
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            for(int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }

        }
    }
}