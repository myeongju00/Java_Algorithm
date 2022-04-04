import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[10];
        arr[0] = "black";
        arr[1] = "brown";
        arr[2] = "red";
        arr[3] = "orange";
        arr[4] = "yellow";
        arr[5] = "green";
        arr[6] = "blue";
        arr[7] = "violet";
        arr[8] = "grey";
        arr[9] = "white";

        long answer = 0;

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        for (int j = 0; j < 10; j++) {
            if(arr[j].equals(str1)) {
                answer += j * 10;
            }
            if(arr[j].equals(str2)) {
                answer += j;
            }
        }
        for (int j = 0; j < 10; j++) {
            if(arr[j].equals(str3)) {
                for(int k = 0; k < j; k++){
                    answer *= 10;
                }
            }
        }
        System.out.println(answer);
    }
}