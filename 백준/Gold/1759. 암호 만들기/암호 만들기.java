import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static boolean[] visited;
    static int L, C;
    static String[] arr;
    static String[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        visited = new boolean[C];
        result = new String[L];


        arr = br.readLine().split(" ");

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int idx, int depth) {
        if(depth == L) {
            int vow = 0, cons = 0;
            String ans = "";
            for (int i = 0; i < C; i++) {
                if(visited[i]) {
                    ans += arr[i];
                    if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                        vow++;
                    } else {
                        cons++;
                    }
                }
            }
            if(vow >= 1 && cons >= 2) sb.append(ans).append("\n");
            return;
        }
        for (int i = idx; i < C; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
            visited[i] = false;

        }
    }

}