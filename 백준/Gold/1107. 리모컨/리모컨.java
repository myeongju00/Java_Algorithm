import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static boolean[] brokens = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                brokens[num] = true;
            }
        }
        
        int answer = Math.abs(N - 100);

        for (int i = 0; i < 1000000; i++) {
            String number = String.valueOf(i);

            boolean isBreak = false;
            for(int j = 0; j < number.length(); j++) {
                if(brokens[number.charAt(j) - '0']) { // 고장난 버튼을 누를 경우
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak) {
                int min = Math.abs(N - i) + number.length();
                answer = Math.min(min, answer);
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }

}