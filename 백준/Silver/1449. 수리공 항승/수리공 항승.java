import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int tapeRange = (int)(arr[0] - 0.5 + L);
        int result = 1;
        for (int i = 1; i < N; i++) {
            if (tapeRange < (int)(arr[i] + 0.5)){
                tapeRange = (int)(arr[i] - 0.5 + L);
                result++;
            }
        }


        System.out.println(result);
    }
}