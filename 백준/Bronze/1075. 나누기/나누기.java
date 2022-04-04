import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, F;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        F = Integer.parseInt(br.readLine());

        N -= N % 100;
        while (N % F != 0) {
            N++;
        }
        N %= 100;
        if(N < 10) System.out.println("0" + N);
        else System.out.println(N);
    }
}