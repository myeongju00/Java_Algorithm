import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int com, linked;
    static int[][] Graph;
    static boolean[] visited;
    static int count = 0;

    static void dfs(int node){
        for(int next = 1; next <= com; next++){
            if(!visited[next] && Graph[node][next] == 1) {
                visited[next] = true;
                dfs(next);
                count++;
            }
        }
    }


    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        com = scanner.nextInt();
        linked = scanner.nextInt();

        Graph = new int[com + 1][com + 1];
        visited = new boolean[com + 1];

        for(int i = 0; i < linked; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            Graph[u][v] = Graph[v][u] = 1;
        }
        visited[1] = true;
        dfs(1);
        System.out.println(count);
    }
}
