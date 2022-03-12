import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] A;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            a[i] = A[i];
        }

        Arrays.sort(a);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(A[i] == a[j]) {
                    sb.append(j).append(" ");
                    a[j] = -1;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}