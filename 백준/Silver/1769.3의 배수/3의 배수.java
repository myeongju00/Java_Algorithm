import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  word = br.readLine();
        number(word, 0);
    }

    private static void number(String word, int cnt) {
        if(word.length() == 1) {
            int result = Integer.parseInt(word);
            System.out.println(cnt);
            if(result % 3 == 0) System.out.println("YES");
            else System.out.println("NO");
            return;
        }
        int next = 0;
        for(int i = 0; i < word.length(); i++) {
            next += word.charAt(i) - '0';
        }
        number(next + "", cnt + 1);
    }
}