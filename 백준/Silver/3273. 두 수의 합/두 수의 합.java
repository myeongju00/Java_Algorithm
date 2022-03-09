import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int num = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int cnt = 0, lPoint = 0, rPoint = N-1;

        while ( lPoint < rPoint ) {
            int sum = arr[lPoint] + arr[rPoint];
            if(sum == num) {
                cnt++;
                lPoint++;
                rPoint--;
            } else if(sum < num) {
                lPoint++;
            } else rPoint--;
        }

        System.out.println(cnt);
    }
}