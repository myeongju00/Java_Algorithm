import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        long num = 0;
        while(pq.size() > 1) {
            long temp = pq.poll();
            long temp2 = pq.poll();

            num += temp + temp2;
            pq.add(temp + temp2);
        }
        sb.append(num);
        System.out.println(sb);
    }

}