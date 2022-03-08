import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int A = 0, B = 1;
        for (int i = 1; i < N; i++) {
            int temp = A + B;
            A = B;
            B = temp;
        }
        System.out.println(A + " " + B);
    }
}