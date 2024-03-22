import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int setPrice = Integer.MAX_VALUE;
        int onePrice = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            setPrice = Math.min(setPrice, Integer.parseInt(st.nextToken()));
            onePrice = Math.min(onePrice, Integer.parseInt(st.nextToken()));
        }

        int set = N / 6;
        int one = N % 6;

        int result = Math.min((set + 1) * setPrice, N * onePrice);
        result = Math.min(result, set * setPrice + one * onePrice);
        System.out.println(result);
    }
}