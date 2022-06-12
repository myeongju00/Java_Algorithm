import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String score = br.readLine();
        int first = 4;
        double last = 0;

        first -= score.charAt(0)-'A';

        if(score.charAt(0)=='F'){
            System.out.println(0.0);
            return;
        }
        if(score.charAt(1)=='+'){
            last = 0.3;
        }
        else if(score.charAt(1)=='0'){
            last = 0.0;
        }
        else{
            last = 0.7;
            first--;
        }
        System.out.println(first+last);
    }
}