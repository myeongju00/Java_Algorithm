import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        // 1, 2, 3, 4, 5, 6, 7

        StringBuilder sb = new StringBuilder();
        sb.append("<");


        int cnt = 1;
        while (queue.size() != 1) {
            if(cnt == K) {
                sb.append(queue.poll()).append(", ");
                cnt = 1;
            } else {
                queue.offer(queue.poll());
                cnt++;
            }
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}