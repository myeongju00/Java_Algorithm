import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            while (coin[i] <= K) {
                K -= coin[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}