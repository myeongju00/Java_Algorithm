import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] cnt = new int[10];

        for (int i = 0; i < N.length(); i++) {
            cnt[N.charAt(i) - '0']++;
        }

        int sixAndNine = cnt[6] +cnt[9];

        if(sixAndNine % 2 == 0) {
            cnt[6] = sixAndNine / 2;
            cnt[9] = sixAndNine / 2;
        } else {
            cnt[6] = sixAndNine / 2 + 1;
            cnt[9] = sixAndNine / 2 + 1;
        }
        int result = 0;
        for(int i : cnt) {
            result = Math.max(result, i);
        }
        System.out.println(result);
    }
}