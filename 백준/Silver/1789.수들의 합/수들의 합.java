import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long num = 1;
        long sum = 1;
        while (sum < S) {
            num ++;
            sum += num;
        }
        if(sum > S) {
            num--;
        }
        sb.append(num).append("\n");
        System.out.println(sb);
    }
}