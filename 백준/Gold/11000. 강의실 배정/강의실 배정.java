import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            time[i][0] = S;
            time[i][1] = T;
        }


        //입력 데이터를 오름차순으로 정렬 (시작 시간이 같다면, 끝나는 시간을 오름차순으로 정렬)
        Arrays.sort(time, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            if(!pq.isEmpty()) {
                if(pq.peek() <= time[i][0]) pq.poll();
            }
            pq.add(time[i][1]);
        }

        System.out.println(pq.size());
    }

}