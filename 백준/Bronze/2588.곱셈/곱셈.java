import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        String B = br.readLine();

        sb.append(A * (B.charAt(2) - '0')).append("\n");
        sb.append(A * (B.charAt(1) - '0')).append("\n");
        sb.append(A * (B.charAt(0) - '0')).append("\n");
        sb.append(A * Integer.parseInt(B)).append("\n");


        System.out.println(sb);
    }
}
