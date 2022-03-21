import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int N;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] level = new int[N];
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        for (int i = N - 1; i > 0; i--) {
            if(level[i - 1] > level[i]) {
                int temp = level[i - 1] - level[i] + 1;
                cnt += temp;
                level[i - 1] -= temp;
            } else if (level[i] == level[i - 1]) {
                cnt++;
                level[i - 1]--;
            }
        }
        System.out.println(cnt);
    }
}