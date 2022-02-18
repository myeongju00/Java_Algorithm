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
        int num = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() >= 6) {
                String  str1 = str.substring(5);
                num = Integer.parseInt(str1);
                queue.add(num);
            } else if(str.equals("pop")) {
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.poll()).append("\n");
            } else if(str.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if(str.equals("empty")) {
                if(queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if(str.equals("front")) {
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peek()).append("\n");
            } else if(str.equals("back")) {
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(num).append("\n");
            }
        }
        System.out.println(sb);
    }
}
