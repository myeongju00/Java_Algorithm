import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String plate = br.readLine();
        int price = 10;

        // (( )) () )(
        for (int i = 1; i < plate.length(); i++) {
            if(plate.charAt(i-1) == plate.charAt(i)) price += 5;
            else price += 10;
        }
        sb.append(price).append("\n");
        System.out.println(sb);
    }
}
