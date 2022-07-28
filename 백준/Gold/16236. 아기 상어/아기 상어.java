import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N;
    static int[][] map;
    static int[] dx = new int[] {0, -1, 1, 0};
    static int[] dy = new int[] {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int[] current = null;

        int size = 2;


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    current = new int[] {i, j};
                    map[i][j] = 0;
                }
            }
        }

        int eaten = 0; // 먹은 물고기 수
        int time = 0; // 움직인 총 거리

        while (true) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visited = new boolean[N][N];
            queue.add(new int[]{current[0], current[1], 0}); // y좌표, x좌표, 이동한 거리
            visited[current[0]][current[1]] = true;
            boolean ck = false;

            while (!queue.isEmpty()) {
                current = queue.poll();
                if (map[current[0]][current[1]] != 0 && map[current[0]][current[1]] < size) {
                    map[current[0]][current[1]] = 0;
                    eaten++;
                    time += current[2];
                    ck = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = current[1] + dx[i];
                    int ny = current[0] + dy[i];
                    if (nx >= N || ny >= N || nx < 0 || ny < 0 || visited[ny][nx] || map[ny][nx] > size) {
                        continue;
                    }
                    queue.add(new int[]{ny, nx, current[2] + 1});
                    visited[ny][nx] = true;
                }
            }
            if (!ck) break;
            if (size == eaten) {
                size++;
                eaten = 0;
            }
        }

        System.out.println(time);
    }
}