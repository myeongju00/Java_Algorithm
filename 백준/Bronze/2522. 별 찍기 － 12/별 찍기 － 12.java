import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (j > N - i && j <= N) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = N - 1; i > 0; i--) {
            for (int j = 1; j <= N; j++) {
                if (j > N - i && j <= N) { 
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }


}