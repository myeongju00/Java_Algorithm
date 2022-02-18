import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                star(i,j);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void star(int i, int j) {
        while (true) {
            if(i == 0) break;
            if(i % 3 == 1 && j % 3 == 1) {
                sb.append(" ");
                return;
            }
            i /= 3;
            j /= 3;
        }
        sb.append("*");
    }
}
