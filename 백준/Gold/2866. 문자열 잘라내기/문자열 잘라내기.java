import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static char[][] table;
    static int count = 0;
    static int R, C;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        table = new char[R][C];

        for (int i = 0; i < R; i++) {
            String r = br.readLine();
            for (int j = 0; j < C; j++) {
                table[i][j] = r.charAt(j);
            }
        }
        count = calculateCount();
        System.out.println(count);
    }

    private static int calculateCount() {
        Set<String> set;
        int cnt = 0;
        String[] arr = new String[C];

        for (int i = 0; i < C; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < R; j++) { 
                sb.append(table[j][i]);
            }
            arr[i] = sb + "";
        }

        for (int i = 0; i < R; i++) {
            set = new HashSet<>();
            for (int j = 0; j < C; j++) {
                String str = arr[j].substring(i);
                if (set.contains(str)) {
                    return cnt;
                } else {
                    set.add(str);
                }
            }
            cnt++;
        }
        return cnt;
    }
}