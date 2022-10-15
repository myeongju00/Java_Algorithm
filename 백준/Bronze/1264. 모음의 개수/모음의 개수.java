import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    public static int vowelChecker(String[] arr) {
        int vowelCount = 0;             // 모음의개수
        for (String str : arr) {
            str = str.toLowerCase();       
            if(str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u")){
                vowelCount++;
            }
        }
        return vowelCount;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            String temp = st.nextToken();              
            if(temp.equals("#")) break;
            
            String[] arr;
            arr = temp.split("");                     
            System.out.println(vowelChecker(arr));
        }

    }
}
