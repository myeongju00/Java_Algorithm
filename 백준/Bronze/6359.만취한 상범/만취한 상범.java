import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[] prison = new boolean[n + 1];
            for(int i = 1; i <= n; i++) { // 라운드
                for (int j = 1; j <= n; j++) {
                    if (j % i == 0) prison[j] = !prison[j];
                }
            }
            int cnt = 0;
            for (boolean x : prison) if(x) cnt++;
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}