import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num % 2 == 1) {
                list.add(num);
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }
        int add = 0;

        for(int i : list) {
            add += i;
        }

        int result = Integer.MAX_VALUE;
        for(int i : list) {
            result = Math.min(result, i);
        }
        System.out.println(add + "\n" + result);
    }
}