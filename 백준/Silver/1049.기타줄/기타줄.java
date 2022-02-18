import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //기타줄 개수
        int M = Integer.parseInt(st.nextToken()); //기타줄 브랜드
        int price;
        int [] pack = new int[M];
        int [] single = new int[M];

        for (int i = 0; i < M; i++) {
            //패키지 가격, 낱개의 가격
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st1.nextToken());
            single[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(pack);
        Arrays.sort(single);

        price = Math.min(((N / 6) + 1) * pack[0], N * single[0]);
        price = Math.min(price, (N / 6) * pack[0] + (N % 6) * single[0]);
        System.out.println(price);
    }
}