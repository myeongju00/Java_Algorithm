import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num, result;
        StringBuilder sb = new StringBuilder();
        while(true) {
            num = br.readLine();
            result = "yes";

            if (num.equals("0")) break;

            for (int i = 0 ; i < num.length() / 2; i++) {
                if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                    result = "no";
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}