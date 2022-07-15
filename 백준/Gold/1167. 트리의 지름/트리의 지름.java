import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int max = 0;
    static int node;
    static boolean[] visited;
    static ArrayList<Node>[] lists;

    static class Node { // 트리(그래프) 저장용
        int end, weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());

            while(true){
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                lists[idx].add(new Node(num, weight));
            }
        }

        visited = new boolean[N + 1];
        dfs(1,0);

        visited = new boolean[N + 1];
        dfs(node,0);

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for(int i = 0; i < lists[x].size(); i++) {
            Node node = lists[x].get(i);
            if(!visited[node.end]) {
                dfs(node.end, node.weight + len);
                visited[node.end] = true;
            }
        }
    }
}