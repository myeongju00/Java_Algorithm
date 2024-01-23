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
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for(int num = 0; num < N; num++) {
            long target = arr[num];
            int left = 0;
            int right = N - 1;

            while(left < right) {
                long sum = arr[left] + arr[right];
                if(sum == target) {
                    if(left != num && right != num) {
                        count++;
                        break;
                    } else if(left == num) {
                        left++;
                    } else {
                        right--;
                    }
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }

}