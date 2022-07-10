import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[][] jewelry = new int[N][2]; //무게, 가격
        int[] C = new int[K]; //최대 무게

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelry[i][0] = Integer.parseInt(st.nextToken()); //무게
            jewelry[i][1] = Integer.parseInt(st.nextToken()); //가격
        }

        Arrays.sort(jewelry, (o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1]; //무게가 같으면 가격 내림차순
            return o1[0] - o2[0];
        });

        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(C); //가방 오름차순

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        long result = 0;

        for (int i = 0; i < K; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음
            while (idx < N && jewelry[idx][0] <= C[i]) {
                queue.offer(jewelry[idx++][1]);
            }

            if(!queue.isEmpty()) {
                result += queue.poll();
            }

        }
        sb.append(result).append("\n");
        System.out.println(sb);
    }
}