import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static int N;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
//            System.setIn(new FileInputStream("src/res/sample_13501_수열_편집.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = 1;
            N = Integer.parseInt(br.readLine());
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                char node = st.nextToken().charAt(0);
                if(st.hasMoreTokens()) {
                    if(node >= '0' && node <= '9') {
                        answer = 0;
                    }
                } else {
                    if (node < '0' || node > '9') {
                        answer = 0;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}