import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[2];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 2; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(arr[0] == 0 && arr[1] == 0) break;
            if (arr[0] > arr[1]) {
                sb.append("Yes").append("\n");
            } else sb.append("No").append("\n");
        }
        System.out.println(sb);
    }
}