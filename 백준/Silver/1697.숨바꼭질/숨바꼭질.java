import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Myeongju> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100_001];
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        queue.offer(new Myeongju(N, S, 0));
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Myeongju mj = queue.poll();
            if (mj.start == mj.end) {
                answer = Math.min(answer, mj.step);
                return;
            }
            // 방문!!!! ㅎㅎ
            visited[mj.start] = true;

            // 방문하는 경우 3 가지
            for (int i = 0; i < 3; i++) {
                int next;
                // 1초 후에 -1 로 이동할 때
                if (i==0) {
                    next = mj.start - 1;
                // 1초 후에 +1 로 이동할 때
                } else if (i==1) {
                    next = mj.start + 1;
                // 1초 후에 *2로 이동할 떄
                } else {
                    next = mj.start * 2;
                }
                if (next>=0 && next <=100000 && !visited[next]) {
                    queue.offer(new Myeongju(next, mj.end, mj.step+1));
                }
            }
        }
    }
}

class Myeongju {
    int start, end, step;

    public Myeongju(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }
}