import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int S = 0;
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "all" :
                    S = (1 << 21) - 1;
                    break;
                case "empty" :
                    S = 0;
                    break;
                default:
                    int num = Integer.parseInt(st.nextToken());
                    switch (str) {
                        case "add" :
                            S |= (1 << num);
                            break;
                        case "remove" :
                            S &= ~(1 << num);
                            break;
                        case "check" :
                            sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                            break;
                        case "toggle" :
                            S ^= (1 << num);
                            break;
                    }
            }
        }
        System.out.println(sb);
    }
}