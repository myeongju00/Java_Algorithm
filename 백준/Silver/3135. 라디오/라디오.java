import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int A, B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int now = A;
        int[] button = new int[N + 2];

        for (int i = 0; i < N; i++) {
            button[2 + i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (Math.abs(B - button[i + 2]) < Math.abs(B - now)) {
                now = button[i + 2];
                cnt = 1;
            }
        }

        while (now != B) {
            if(now > B) {
                now--;
                cnt++;
            } else { //now < B
                now++;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}