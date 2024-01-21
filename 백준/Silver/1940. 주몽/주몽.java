import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int count = 0;
        int startIdx = 0;
        int endIdx = N - 1;

        while (startIdx < endIdx) {
            int sum = arr[startIdx] + arr[endIdx];
            if (sum < M) {
                startIdx++;
            } else if (sum > M){
                endIdx--;
            } else {
                count++;
                startIdx++;
                endIdx--;
            }
        }
        sb.append(count);
        System.out.println(sb);
    }

}