import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int tCount = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tArr = new int[6];
        for(int i = 0; i < 6; i++) {
            tArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        for(int num : tArr) {
            if (num == 0) {
            } else if(num <= T) {
                tCount++;
            } else {
                if(num % T == 0) {
                    tCount += (num / T );
                } else {
                    tCount += (num / T ) + 1;
                }
            }
        }

        System.out.println(tCount);
        System.out.println( N / P + " " + N % P);

    }
}