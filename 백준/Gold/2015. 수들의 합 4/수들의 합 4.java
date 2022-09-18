import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        Map<Integer, Long> hashMap = new HashMap<>();

        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
            if(arr[i] == K) answer++;
            if(hashMap.containsKey(arr[i] - K)) {
                answer += hashMap.get(arr[i] - K);
            }
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i], 0L) + 1);
        }

        System.out.println(answer);
    }
}