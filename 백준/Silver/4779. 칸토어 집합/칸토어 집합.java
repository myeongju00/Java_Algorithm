import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str="";

        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            int num = (int) Math.pow(3, N);
            arr = new char[num];

            for (int i = 0; i < num; i++) {
                arr[i] = '-';
            }

            dfs(0, num);

            for(char c : arr) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int start, int length) {
        if(length < 3) {
            return;
        }

        int startIndex = start + length / 3;
        int endIndex = start + length / 3 * 2;
        for (int i = startIndex; i < endIndex; i++) {
            arr[i] = ' ';
        }
        
        dfs(start, length / 3);
        dfs(endIndex, length / 3);
    }
}