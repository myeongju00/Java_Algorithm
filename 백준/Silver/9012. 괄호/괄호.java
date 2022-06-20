import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else { //')'
                    if(stack.empty() || stack.peek() == ')'){
                        stack.push(c);
//                    } else if(stack.peek() == ')'){
//                        stack.push(c);
                    } else stack.pop();
                }

            }
            if(stack.empty()) {
                sb.append("YES").append("\n");
            } else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}