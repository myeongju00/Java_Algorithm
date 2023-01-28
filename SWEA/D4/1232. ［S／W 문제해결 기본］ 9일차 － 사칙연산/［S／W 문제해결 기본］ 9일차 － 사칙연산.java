import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    private static int N;
    static Stack<Double> stack;
    static int[][] tree;
    static String[] value;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
//            System.setIn(new FileInputStream("src/res/sample_13501_수열_편집.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            tree = new int[N + 1][2];
            value = new String[N + 1];

            for(int i = 1; i <= N; i++) {
                String[] arr = br.readLine().split(" ");

                value[i] = arr[1];
                stack = new Stack<>();

                if(arr.length == 4) {
                    int a = Integer.parseInt(arr[0]);
                    int b = Integer.parseInt(arr[2]);
                    int c = Integer.parseInt(arr[3]);

                    tree[a][0] = b;
                    tree[a][1] = c;
                }
            }
            rearwardTurn(1);

            int result = stack.pop().intValue();
            sb.append("#").append(test_case).append(" ").append(result);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rearwardTurn(int x) {
        if(tree[x][0] == 0 && tree[x][1] == 0) {
            operation(value[x]);
        } else {
            if(tree[x][0] != 0) {
                rearwardTurn(tree[x][0]);
            }

            if(tree[x][1] != 0) {
                rearwardTurn(tree[x][1]);
            }

            operation(value[x]);
        }
    }

    static void operation(String v) {
        // 숫자일 경우
        if(!v.equals("+") && !v.equals("-") && !v.equals("*") && !v.equals("/")) {
            stack.push(Double.parseDouble(v));
            return;
        }
        Double b = stack.pop();
        Double a = stack.pop();

        if(v.equals("+")) {
            stack.push(a + b);
        } else if(v.equals("-")) {
            stack.push(a - b);
        } else if(v.equals("*")) {
            stack.push(a * b);
        } else if(v.equals("/")) {
            stack.push(a / b);
        }
    }
}