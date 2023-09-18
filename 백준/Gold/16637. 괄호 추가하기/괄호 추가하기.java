import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    static int answer = Integer.MIN_VALUE;
    static ArrayList<Character> ops;
    static ArrayList<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        ops = new ArrayList<>();
        nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
                continue;
            }

            nums.add(Character.getNumericValue(c));
        }
        dfs(nums.get(0), 0);
        System.out.println(answer);
    }

    public static void dfs(int result, int idx) {
        if (idx >= ops.size()) { //연산자 개수 초과
            answer = Math.max(answer, result);
            return;
        }

        //괄호 X
        int next = calculate(ops.get(idx), result, nums.get(idx + 1));
        dfs(next, idx + 1);

        //괄호 O
        if (idx + 1 < ops.size()) {
            //result 오른쪽 값 연산
            int next2 = calculate(ops.get(idx + 1), nums.get(idx + 1), nums.get(idx + 2));
            dfs(calculate(ops.get(idx), result, next2), idx + 2);
        }
    }

    public static int calculate(char op, int num1, int num2) {
        if(op == '+') {
            return num1 + num2;
        } else if(op == '-') {
            return num1 - num2;
        } else if(op == '*') {
            return num1 * num2;
        }
        return -1;
    }
}