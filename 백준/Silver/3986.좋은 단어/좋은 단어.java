import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            for(int j = 0; j < word.length(); j++){
                if(stack.isEmpty()) {
                    stack.push(word.charAt(j));
                    continue;
                } else {
                    if (stack.peek() == word.charAt(j)) {
                        stack.pop();
                    } else stack.push(word.charAt(j));
                }
            }
            if(stack.isEmpty()) cnt++;
            else stack.clear();
        }
        sb.append(cnt).append("\n");
        System.out.println(sb);
    }
}
