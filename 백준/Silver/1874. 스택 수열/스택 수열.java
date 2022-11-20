import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int startNum = 0;

        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if(number > startNum) {
                for (int i = startNum + 1; i <= number; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                startNum = number;
            } else if (stack.peek() != number) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}