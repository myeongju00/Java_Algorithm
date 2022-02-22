import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());

            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());

            //겹치지 X
            if (x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) sb.append("d").append("\n");
            else if((x1 == x4 && y1 == y4) || (x2 == x3 && y1 == y4) || (x2 == x3 && y2 == y3) || (x1 == x4 && y2 == y3)) {
                sb.append("c").append("\n"); //점
            } else if((x1 == x4 && y1 != y4) || (x2 != x3 && y1 == y4) || (x2 == x3 && y2 != y3) || (x1 != x4 && y2 == y3)) {
                sb.append("b").append("\n"); //선분
            } else sb.append("a").append("\n");
        }
        System.out.println(sb);
    }
}