import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        boolean resultFlag = true;
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
                resultFlag = false;
                break;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        if (!resultFlag) {
            sb = new StringBuilder();
            sb.append("NO");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}