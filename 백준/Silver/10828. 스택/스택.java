import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int num = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() >= 6) {
                String  str1 = str.substring(5);
                num = Integer.parseInt(str1);
                stack.push(num);
            } else if(str.equals("pop")) {
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            } else if(str.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if(str.equals("empty")) {
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if(str.equals("top")) {
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}