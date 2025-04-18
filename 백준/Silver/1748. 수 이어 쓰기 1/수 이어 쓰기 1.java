import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = 1;
        int count = 0;
        int start = 1;

        while (start * 10 <= N) {
            count += (start * 10 - start) * length;
            start *= 10;
            length++;
        }

        count += (N - start + 1) * length;

        System.out.println(count);
    }
}