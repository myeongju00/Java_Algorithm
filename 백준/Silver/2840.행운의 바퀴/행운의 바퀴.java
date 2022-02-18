import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int point = 0; // 현재위치

        char[] arr = new char[N]; //바퀴 배열
        Arrays.fill(arr, '?'); //?로 채워넣기
        boolean[] visited = new boolean[26]; //알파벳 배열
        boolean possible = true;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int loop = Integer.parseInt(st.nextToken());
            char alpha = st.nextToken().charAt(0);

            point = (point + loop) % N; //원형
            if (arr[point] != '?' && arr[point] != alpha || arr[point] != alpha && visited[alpha - 'A']) {
                // 현재 위치가 채워져있고, 입력받은 알파벳이랑 같지 않거나(다른 알파벳), 입력받았던 알파벳이 아니고,방문한적이 없으면?
                possible = false; // 표시
            }
            arr[point] = alpha;
            visited[alpha - 'A'] = true;
        }

        int temp;
        if(possible) {
            for (int j = 0; j < N; j++) {
                temp = point - j;
                if(temp < 0) temp += N;
                sb.append(arr[temp]);
            }
        } else {
            System.out.println("!");
            return;
        }
        System.out.println(sb);
    }
}
