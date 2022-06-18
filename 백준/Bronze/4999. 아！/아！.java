import java.util.*;
import java.io.*;
          
public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw.write(br.readLine().length() >= br.readLine().length() ? "go" : "no");
        bw.flush();
    }
}