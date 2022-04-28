import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String tmp = br.readLine();
            if (tmp.equals("0")) {
                break;
            }
            String[] num = tmp.split("");
            testNum(num);
        }
    }

    static void testNum(String[] num) {
        int rslt = 0;
        for (int i = 0; i < num.length; i++) {
            rslt += Integer.parseInt(num[i]);
        }
        if((rslt / 10) == 0) {
            System.out.println(rslt);
        } else {
            testNum(String.valueOf(rslt).split(""));
        }
    }
}