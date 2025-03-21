import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= 1000000; i++) {
            if(i + calculate(i) == N) {
                answer = i;
                break;
            }
        }
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    public static int calculate(int number) {
        String word = number + "";
        int sum = 0;
        for(int i = 0; i < word.length(); i++) {
            sum += word.charAt(i) - '0';
        }
        return sum;
    }
}