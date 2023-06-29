import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] givenArray = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            givenArray[i] = Integer.parseInt(st.nextToken());
            arr[i] = givenArray[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(givenArray[i] == arr[j]) {
                    sb.append(j).append(" ");
                    arr[j] = -1;
                    break;
                }
            }
        }
        System.out.println(sb);
    }

}