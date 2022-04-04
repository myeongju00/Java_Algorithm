import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = arr[0];
        int cnt = 0;
        while(true) {
            for(int i = 0; i < 5; i++) {
                if(min % arr[i] == 0) {
                    cnt++;
                }
            }
            if(cnt >= 3) {
                System.out.println(min);
                return;
            }
            cnt = 0;
            min++;
        }
    }
}