import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(queue.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }

        sb.append(queue.poll() + ">");

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}