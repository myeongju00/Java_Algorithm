import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 1000000; i++) {
            if (makeNum(i) == N) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static int makeNum(int num) {
        String word = num + "";
        int replaceNum = num;
        for (int i = 0; i < word.length(); i++) {
            replaceNum += word.charAt(i) - '0';
        }
        return replaceNum;
    }
}
