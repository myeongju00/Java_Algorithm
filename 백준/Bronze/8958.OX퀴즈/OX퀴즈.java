import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        char[] word;
        int[] pos;
        while (T-- > 0) {
            int answer = 0;
            word = br.readLine().toCharArray();
            pos = new int[word.length];
            for (int i = 0; i < word.length; i++) {
                if (word[i] == 'O') {
                    if (i > 0 && pos[i-1] != 0) {
                        pos[i] = pos[i-1]+1;
                    }
                    else {
                        pos[i] = 1;
                    }
                    answer += pos[i];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}