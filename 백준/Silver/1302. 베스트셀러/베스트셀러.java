import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> book = new HashMap<>();
        while (N-- > 0) {
            String str = br.readLine();
            if(!book.containsKey(str)) {
                book.put(str, 1);
            } else {
                int value = book.get(str);
                book.replace(str, value + 1);
            }
        }

        int cnt = 0;
        String result = "";
        for (String k : book.keySet()) {
            if(cnt < book.get(k)) {
                cnt = book.get(k);
                result = k;
            } else if (cnt == book.get(k)) {
                if(result.compareTo(k) > 0) {
                    result = k;
                }
            }
        }
        System.out.println(result);

    }
}