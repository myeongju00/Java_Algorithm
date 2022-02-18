import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] money = new int[] {500, 100, 50, 10, 5, 1};
        while (N != 0){
            for (int j : money) {
                cnt += N / j;
                N %= j;
            }
        }
        sb.append(cnt).append("\n");
        System.out.println(sb);
    }
}
