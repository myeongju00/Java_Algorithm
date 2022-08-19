import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

//    static int[] dx = new int[] {1, -1, 0, 0};
//    static int[] dy = new int[] {0, 0, 1, -1};
    static int N, M, A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); //동규
        M = Integer.parseInt(st.nextToken()); //주미
        bfs();
    }

    static void bfs() {
        int[] stones = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        stones[N] = 1;

        while(!queue.isEmpty()) {
            int stone = queue.poll();
            if(stone == M) break;
            if (stone + 1 <= 100000 && stones[stone + 1] == 0) {
                queue.add(stone + 1);
                stones[stone + 1] = stones[stone] + 1;
            }
            if (stone - 1 >= 0 && stones[stone - 1] == 0) {
                queue.add(stone - 1);
                stones[stone - 1] = stones[stone] + 1;
            }
            if (stone + A <= 100000 && stones[stone + A] == 0) {
                queue.add(stone + A);
                stones[stone + A] = stones[stone] + 1;
            }
            if (stone * A <= 100000 && stones[stone * A] == 0) {
                queue.add(stone * A);
                stones[stone * A] = stones[stone] + 1;
            }
            if (stone - A >= 0 && stones[stone - A] == 0) {
                queue.add(stone - A);
                stones[stone - A] = stones[stone] + 1;
            }

            if (stone + B <= 100000 && stones[stone + B] == 0) {
                queue.add(stone + B);
                stones[stone + B] = stones[stone] + 1;
            }
            if (stone - B >= 0 && stones[stone - B] == 0) {
                queue.add(stone - B);
                stones[stone - B] = stones[stone] + 1;
            }

            if (stone * B <= 100000 && stones[stone * B] == 0) {
                queue.add(stone * B);
                stones[stone * B] = stones[stone] + 1;
            }
        }
        System.out.println(stones[M] - 1);
    }
}
