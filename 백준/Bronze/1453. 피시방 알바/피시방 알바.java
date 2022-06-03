import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Boolean> customer = new HashMap<Integer, Boolean>();
        int cnt = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements()) {
            int num = Integer.parseInt(st.nextToken());
            if(customer.getOrDefault(num, false)) {
                cnt++;
            } else{
                customer.put(num, true);
            }
        }

        System.out.println(cnt);
    }
}