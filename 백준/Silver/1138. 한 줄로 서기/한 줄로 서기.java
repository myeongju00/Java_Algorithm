import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int j = 0 ; j < N ; j++) {
                if(!visited[j]) {
                    if(cnt == n) {
                        visited[j] = true;
                        arr[j] = i+1;
                        break;
                    }
                    cnt++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}