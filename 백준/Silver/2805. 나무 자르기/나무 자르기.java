import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = 0;
        int max = arr[N - 1];

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for(int h : arr) {
                if(h - mid > 0) {
                    sum += (h - mid);
                }
            }

            if(sum < M) { //나무길이 합 > M -> 높이 낯춰야함
                max = mid;
            }
            else { // 길이합 > M -> 높이 높여야함
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}