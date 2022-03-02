import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String word = br.readLine();
        int cnt = 0;

        for (int i = 0; i <= str.length() - word.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                if(str.charAt(i + j) != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                cnt++;
                i += word.length() - 1;
            }
        }
        System.out.println(cnt);
    }
}