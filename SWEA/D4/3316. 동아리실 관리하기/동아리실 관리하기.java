import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static int N;
    public static void main(String[] args) throws Exception {
//            System.setIn(new FileInputStream("src/res/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int R = 1_000_000_007;

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            N = str.length();
            long[][] record = new long[N][1 << 4];

            for (int day = 0; day < N; day++) {
                int turn = 1 << (str.charAt(day) - 'A');

                for (int sub = 0; sub < (1 << 4); sub++) { // 지난 날의 경우(어제)
                    if (day == 0) {
                        if ((sub & turn) > 0 && (sub & 1) > 0) {
                            record[0][sub] = 1;
                        }
                    } else {
                        if (record[day - 1][sub] == 0)
                            continue;
                        for (int i = 0; i < (1 << 4); i++) {// 다가올 날의 경우(오늘)
                            if ((sub & i) > 0 && (turn & i) > 0) {
                                record[day][i] += record[day - 1][sub];
                                record[day][i] %= R;
                            }
                        }
                    }
                }
            }

            long answer = 0;
            for (int i = 0; i < (1 << 4); i++) {
                answer += record[N - 1][i];
                answer %= R;
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}