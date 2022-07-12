import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] arr = br.readLine().split("");
        int OneCnt = 0;
        int ZeroCnt = 0;

        if(arr[0].equals("0")) ZeroCnt++;
        else OneCnt++;

        for(int i = 1; i < arr.length; i++) {
            if(!arr[i - 1].equals(arr[i])) {
                if(arr[i].equals("0")) ZeroCnt++;
                else OneCnt++;
            }
        }

        System.out.println(Math.min(ZeroCnt, OneCnt));
    }
}