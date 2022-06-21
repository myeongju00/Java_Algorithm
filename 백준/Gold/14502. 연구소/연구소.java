import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;

    static int[] dr = { -1, 1, 0, 0 }; //상하좌우
    static int[] dc = { 0, 0, -1, 1 }; //상하좌우
    static int result = Integer.MIN_VALUE; //안전지역 개수

    static class virus {
        int x, y;

        virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        System.out.println(result);
    }

    // 벽 세우기
    public static void DFS(int depth) {
        if (depth == 3) {
            BFS();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {
        int[][] virus_map = new int[N][M];
        Queue<virus> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(map[i], 0, virus_map[i], 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //바이러스라면
                if (virus_map[i][j] == 2) que.add(new virus(i, j));
            }
        }

        while (!que.isEmpty()) {
            virus v = que.remove();

            for (int i = 0; i < 4; i++) {
                int nr = v.x + dr[i];
                int nc = v.y + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    if (virus_map[nr][nc] == 0) {
                        virus_map[nr][nc] = 2;
                        que.add(new virus(nr, nc));
                    }
                }
            }
        }
        safe(virus_map);
    }

    public static void safe(int[][] virus_map) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_map[i][j] == 0) count++;
            }
        }

        result = Math.max(count, result);
    }
}