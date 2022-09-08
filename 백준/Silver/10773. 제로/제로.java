import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n != 0) {
                stack.add(n);
            }
            if (!stack.isEmpty() && n == 0) {
                stack.pop();
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}