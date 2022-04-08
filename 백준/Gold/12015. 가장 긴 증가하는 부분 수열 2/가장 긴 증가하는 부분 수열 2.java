import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int left = 1;
                int right = list.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < num){
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, num);
            }
        }
        System.out.println(list.size() - 1);
    }
}