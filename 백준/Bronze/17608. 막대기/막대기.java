import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    static int N;

    static Stack <Integer> stack = new Stack<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int max = stack.pop();

        int cnt = 1;

        while(!stack.isEmpty()) {
            int h = stack.pop();
            if( max < h) {
                max = h;
                cnt++;
            }

        }

        System.out.println(cnt);
    }
}