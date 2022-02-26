import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            hashMap.put(num, hashMap.getOrDefault(num,0)+1);
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(num)) {
                sb.append(hashMap.get(num)).append(" ");
            }
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}