import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int cnt = 0;
            Queue<int[]> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { //위치, 중요도
                queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            while (!queue.isEmpty()) {
                int []front = queue.poll();
                boolean flag = true;
                for(int []q : queue) {
                    if (q[1] > front[1]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    cnt++;
                    if(front[0] == M) break;
                } else queue.add(front);
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}