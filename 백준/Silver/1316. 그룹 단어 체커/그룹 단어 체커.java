import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main{

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int result = 0;

        while (N-- > 0) {
            char[] words = br.readLine().toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            map.put(words[0], 1);
            boolean flag = true;

            for (int i = 1; i < words.length; i++) {
                if (!map.containsKey(words[i])) {
                    map.put(words[i], 1);
                } else if (words[i - 1] == words[i]) {
                    map.put(words[i], map.get(words[i]) + 1);
                } else if (words[i - 1] != words[i] && map.containsKey(words[i])) {
                    flag = false;
                }
            }

            if(flag) {
                result++;
            }
        }
        System.out.println(result);
    }


}