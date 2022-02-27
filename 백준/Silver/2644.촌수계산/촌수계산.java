import java.io.*;
import java.util.*;

public class Main {
    static int start, end, answer = -1;
    static boolean[] visited;

    // 양방향 인접리스트
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //전체 사람의 수
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); //부모 자식들 간의 관계의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 양방향
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        // 시작 정점, 촌 수
        dfs(start, 0);
        // 모두 방문해서 end 가 없으면 -1 있으면 현재 촌수 출력
        System.out.println(answer);
    }

    private static void dfs(int current, int cnt) {
        visited[current] = true;
        for (int x : graph.get(current)) {
            if (!visited[x]) {
                // 기저 조건
                if (x == end) {
                    answer = cnt + 1;
                    return;
                }
                // 방문하지 않았으면 다음 촌수로 이동
                dfs(x, cnt + 1);

            }
        }
    }
}