import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static HashSet<String> set;
    static boolean[] visited;
    static char[] sCharArr;
    static int size = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        sCharArr = s.toCharArray();

        set = new HashSet<String>();
        int len = s.length();

        for(int i = 0; i < len; i++) {
            visited = new boolean[len];
            StringBuilder sb = new StringBuilder();
            sb.append(sCharArr[i]);
            visited[i] = true;

            backTracking(sb, len);
        }

        char[] alphabet = new char[26];
        for(int i = 0; i < len; i++) {
            alphabet[sCharArr[i] - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(alphabet[i] >= 2) {
                size /= factorial(alphabet[i]);
            }
        }
        System.out.println(size);
    }

    static void backTracking(StringBuilder sb, int n) {
        if(sb.length() == n) {
            size++;
            return;
        }
        else {
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    if(sb.charAt(sb.length() - 1) != sCharArr[i]) {
                        visited[i] = true;
                        sb.append(sCharArr[i]);
                        backTracking(sb, n);
                        sb.deleteCharAt(sb.length() - 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }

    public static int factorial(int n) {
        if(n == 1)
            return 1;

        return n * factorial(n - 1);
    }
}