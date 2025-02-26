import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static int N;
    public static int K;
    public static int[] dMove = {-1, 1, 2};
    public static int[] count;
    public static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = new int[100001];

        count[N] = 1;
        queue.add(N);

        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
        }

    }

    public static void bfs () {
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int i = 0; i < 3; i++) {
                int next;
                if(i == 2) {
                    next = now * dMove[i];
                } else {
                    next = now + dMove[i];
                }
                if(next == K) {
                    System.out.println(count[now]);
                    return;
                }
                if(next >= 0 && next <= 100000 && count[next] == 0) {
                    queue.add(next);
                    count[next] = count[now] + 1;
                }
            }
        }
    }
}