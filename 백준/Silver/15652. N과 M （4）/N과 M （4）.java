import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0, 1);
        System.out.println(sb);
    }
    private static void dfs(int depth, int point){
        if(depth == M) {
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = point; i < N + 1; i++) {
            arr[depth] = i;
            dfs( depth + 1, i);
        }
    }
}