import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            for (int j = 0; j < num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int sub = Integer.MIN_VALUE;

            for (int j = 0; j < num - 1; j++) {
                sub = Math.max(arr[j + 1] - arr[j], sub);
            }

            sb.append("Class ").append(i).append("\n");
            sb.append("Max ").append(arr[num - 1]).append(", Min ").append(arr[0])
                    .append(", Largest gap ").append(sub).append("\n");
        }
        System.out.println(sb);
    }
}