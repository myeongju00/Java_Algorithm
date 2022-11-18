import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] medianExpression = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        String regex = "^[A-Z]";

        for (int i = 0; i < medianExpression.length; i++) {
            if (Pattern.matches(regex, medianExpression[i] + "")) {
                sb.append(medianExpression[i]);
            } else {
                if(medianExpression[i] == '(') {
                    stack.push(medianExpression[i]);
                } else if (medianExpression[i] == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(medianExpression[i])) {
                        sb.append(stack.pop());
                    }
                    stack.push(medianExpression[i]);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
    public static int priority(char operator) {
        if(operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 0;
        }

    }
}