import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static int N;
    private static char[] tree;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
//            System.setIn(new FileInputStream("src/res/sample_13501_수열_편집.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            tree = new char[N + 1];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                tree[i] = st.nextToken().charAt(0);
            }
            sb.append("#").append(test_case).append(" ");
            inOrder(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void inOrder(int idx) {
        if(idx > N) {
            return;
        }
        inOrder(2 * idx);
        sb.append(tree[idx]);
        inOrder(2 * idx + 1);
    }
}