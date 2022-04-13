import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static int[] input;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        visited = new boolean[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        dfs(0, 0);


        System.out.println(sb);
    }
    private static void dfs(int depth, int index){
        if(depth == M) {
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i < N; i++) {
            arr[depth] = input[i];
            dfs(depth + 1, i);
        }
    }
}