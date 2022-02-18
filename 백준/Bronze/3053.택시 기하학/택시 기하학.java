import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double R = Integer.parseInt(br.readLine());

        double u = R * R * Math.PI;
        double taxi = R * R * 2;

        sb.append(String.format("%.6f", u)).append("\n");
        sb.append(String.format("%.6f", taxi)).append("\n");

        System.out.println(sb);
    }
}