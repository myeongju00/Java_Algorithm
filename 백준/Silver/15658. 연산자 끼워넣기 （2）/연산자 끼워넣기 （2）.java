import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] numArr;
    static int[] operator;
    static int result_min = Integer.MAX_VALUE;
    static int result_max = Integer.MIN_VALUE;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numArr[0]);

        System.out.println(result_max);
        System.out.println(result_min);
    }

    public static void dfs(int idx, int sum) {
        if (idx == N) {
            result_min = Math.min(result_min, sum);
            result_max = Math.max(result_max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;
            operator[i]--;
            switch(i) {
                case 0:
                    dfs(idx + 1, sum + numArr[idx]);
                    break;
                case 1:
                    dfs(idx + 1, sum - numArr[idx]);
                    break;
                case 2:
                    dfs(idx + 1, sum * numArr[idx]);
                    break;
                case 3:
                    dfs(idx + 1, sum / numArr[idx]);
                    break;
            }
            operator[i]++;
        }
    }
}