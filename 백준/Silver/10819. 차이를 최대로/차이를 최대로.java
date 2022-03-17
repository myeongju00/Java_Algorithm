import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] sumArr;
    static boolean[] visited;
    static int N, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        sumArr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if(depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(sumArr[i + 1] - sumArr[i]);
                answer = Math.max(answer, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                sumArr[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}