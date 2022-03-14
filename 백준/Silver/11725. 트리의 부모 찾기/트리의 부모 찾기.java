import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents; // 부모 노드의 번호를 담을 배열
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 양방향 그래프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        parents = new int[N + 1]; // 1~ N 까지니까
        StringTokenizer st;
        // 1~N까지 쓸꺼긴한데 공간을 만들어야하니까 0~N까지 초기화해줘야 쓸수있음
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 양방향 그래프 처리
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // 루트가 1번이니까 1번부터 탐색시작
        dfs(1);

        // 정답 출력 2번노드부터 N번까지
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int n) {
        // 해당 노드에서 갈 수 있는 것들 중
        for (int x : graph.get(n)) {
            // 0이라면 아직 부모가 없는 경우니까 접근
            if (parents[x] == 0) {
                // 해당 노드의 부모를 들어온 노드인 n으로 넣어주고
                parents[x] = n;
                // 다시 그 n에서 갈 수 있는 노드를 탐색
                dfs(x);
            }
        }
    }
}