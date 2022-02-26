import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            long num = Integer.parseInt(st.nextToken());
            queue.offer(num);
        }
        for (int i = 0; i < m; i++) {
            long x = queue.poll();
            long y = queue.poll();
            queue.offer(x + y);
            queue.offer(x + y);
        }

        long sum = 0;
        while(!queue.isEmpty()) {
            sum += queue.poll();
        }

        sb.append(sum).append("\n");
        System.out.println(sb);
    }
}