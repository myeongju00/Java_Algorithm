import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(st.nextToken());
        int X = Integer.parseInt(sb.reverse().toString());

        sb.setLength(0);

        sb.append(st.nextToken());
        int Y = Integer.parseInt(sb.reverse().toString());

        sb.setLength(0);

        sb.append(X+Y);

        System.out.println(Integer.parseInt(sb.reverse().toString()));
    }
}