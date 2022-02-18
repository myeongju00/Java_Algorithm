import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> line = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            line.add(i - num - 1, i);
        }
        for (Integer i : line) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
