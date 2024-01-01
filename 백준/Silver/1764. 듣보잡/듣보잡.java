import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();


        for(int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }
        List<String> answerList = new ArrayList<>();
        for (int i = N + 2; i < N + M + 2; i++) {
            String name = br.readLine();
            if(set.contains(name)) {
                answerList.add(name);
            }
        }

        Collections.sort(answerList);

        sb.append(answerList.size()).append("\n");
        for (String name : answerList) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}