import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> row = new ArrayList<>();
    static List<Integer> col = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        row.add(W);
        col.add(H);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if(x == 0) {
                col.add(length);
            } else {
                row.add(length);
            }
        }


        Collections.sort(row);
        Collections.sort(col);

        int rowMax = cut(row);
        int colMax = cut(col);

        sb.append(rowMax * colMax).append("\n");

        System.out.println(sb);
    }
    static int cut(List<Integer> cut) {
        int start = 0;
        int result = 0;

        for (Integer i : cut) {
            int temp = i - start;
            if (result < temp) result = temp;
            start = i;
        }
        return result;
    }
}