import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while(queue.size() != 0) {
            if(queue.size() == 1) sb.append(queue.peek()).append(" ");
            queue.remove();
            queue.add(queue.peek());
            queue.remove();
        }
        System.out.println(sb);
    }
}