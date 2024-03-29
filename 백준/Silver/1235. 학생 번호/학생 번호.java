import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] student = new String[N];
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        int len = 0;
        for(int i = 0; i < N; i++){
            student[i] = br.readLine();
            if(i == 0) len = student[i].length();
        }
        int k = 0;
        base:
        for(int i = 0; i <= len; i++){
            for(int j = 0; j < N; j++){
                String sub = student[j].substring(len - i);
                if(map.containsKey(sub)){
                    map.clear();
                    continue base;
                } else {
                    map.put(sub, true);
                }
            }
            k = i;
            break;
        }
        bw.write(k + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}