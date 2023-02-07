import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if(N <= 10) {
            System.out.println(N);
        } else if(N > 1022) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < 10; i++) {
                check(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }

    }

    private static void check(long num, int depth) {
        if(depth > 10) {
            return;
        }
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            check((num * 10) + i, depth + 1);
        }
    }
}