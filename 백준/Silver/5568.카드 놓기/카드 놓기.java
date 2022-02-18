import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static String[] card;
    static boolean[] visited;
    static int k, n;
    static HashSet<String> hashset = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new String[n];
        for (int i = 0; i < n; i++) {
            card[i] = br.readLine();
        }
        visited = new boolean[n];
        //select
        selectCard(k,"");
        sb.append(hashset.size()).append("\n");
        System.out.println(sb);
    }
    private static void selectCard(int num, String c) {
        if(num == 0) {
            hashset.add(c);
            return;
        }
        for(int i = 0; i < n; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                selectCard(num - 1, c + card[i]);
                visited[i] = false;
            }
        }
    }
}