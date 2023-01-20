import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    private static int N;
    private static List<Integer> message;
    public static void main(String[] args) throws Exception {
//            System.setIn(new FileInputStream("src/res/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            message = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                message.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                String cmd = st.nextToken();
                if(cmd.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    insert(x, y, st);
                } else if (cmd.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    delete(x, y);
                } else {
                    int y = Integer.parseInt(st.nextToken());
                    add(y, st);
                }
            }
            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(message.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void insert(int x, int y, StringTokenizer st) {
        for (int i = 0; i < y; i++) {
            int s = Integer.parseInt(st.nextToken());
            message.add(x + i, s);
        }
    }
    public static void delete(int x, int y) {
        for (int i = 0; i < y; i++) {
            message.remove(x);
        }
    }
    public static void add(int y, StringTokenizer st) {
        for (int i = 0; i < y; i++) {
            int s = Integer.parseInt(st.nextToken());
            message.add(s);
        }

    }
}