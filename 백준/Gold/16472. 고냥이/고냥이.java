import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String string = br.readLine();

        int count = 1, answer = 0;
        alphabet[string.charAt(0) - 'a']++;

        for(int start = 0, end = 1; end < string.length(); end++) {
            if(alphabet[string.charAt(end) - 'a']++ == 0) {
                count++;
            }
            // count가 N보다 크면? 줄어들 때 까지 start 위치를 이동
            while (N < count && start < end) {
                if (--alphabet[string.charAt(start++) - 'a'] == 0) count--;
            }
            answer = Math.max(answer, end - start + 1);
        }
        System.out.println(answer);
    }
}
