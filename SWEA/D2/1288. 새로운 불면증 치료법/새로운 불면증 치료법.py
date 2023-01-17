import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    private static int N;

    public static void main(String[] args) throws Exception {
//            System.setIn(new FileInputStream("src/res/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            N = Integer.parseInt(str);
            boolean[] visited = new boolean[10];
            int multiple = 1;
            int count = 0;
            while (true) {
                for (int i = 0; i < str.length(); i++) {
                    int temp = Integer.parseInt(str.substring(i, i + 1));
                    if(!visited[temp]) {
                        visited[temp] = true;
                        count++;
                    }
                }
                if(count == 10) {
                    break;
                } else {
                    multiple++;
                    str = Integer.toString(N * multiple);
                }
            }
            sb.append("#").append(test_case).append(" ").append(str).append("\n");
        }
        System.out.println(sb);
    }
}