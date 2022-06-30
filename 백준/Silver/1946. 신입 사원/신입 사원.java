import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<int[]> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new int[] {a, b});
            }
            Collections.sort(list, ((o1, o2) -> {
                if (o1[0] < o2[0]) {
                    return -1;
                } else return 1;
            }));

            int cnt = 1;
            int min = list.get(0)[1];
            for (int i = 1; i < N; i++) {
                if(list.get(i)[1] < min) {
                    cnt++;
                    min = list.get(i)[1];
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}