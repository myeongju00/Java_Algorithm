import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int result = 0;
        for(int i = 0; i < N; i++){
            char[] alphabet = new char[26];
            char[] arr = br.readLine().toCharArray();
            boolean flag = true;

            alphabet[arr[0] - 'a']++;
            for(int j = 1; j < arr.length; j++){
                if(alphabet[arr[j] - 'a'] == 0) {
                    alphabet[arr[j] - 'a']++;
                } else {
                    if(arr[j - 1] != arr[j]) {
                        flag = false;
                    }
                }
            }
            if(flag) {
                result++;
            }
        }

        System.out.println(result);
    }
}