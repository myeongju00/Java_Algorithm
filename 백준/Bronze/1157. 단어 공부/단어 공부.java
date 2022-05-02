import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        char[] str = new BufferedReader(new InputStreamReader(System.in)).readLine().toUpperCase().toCharArray();
        // toUpperCase() : 대문자 변환
        for(char i : str) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(max < map.get(i)) max = map.get(i);
        }

        int cnt = 0;
        char ch = '?';
        for(Entry<Character, Integer> tmpMap : map.entrySet()) {
            if(tmpMap.getValue().equals(max)) {
                cnt++;
                ch = tmpMap.getKey();
            }
        }
        System.out.print(cnt > 1 ? "?" : ch);
    }
}