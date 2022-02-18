import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            String[] word = new String[num];
            String result;
            for (int j = 0; j < num; j++) {
                word[j] = br.readLine(); // 입력받기
            }

            outer :for (int j = 0; j < num; j++) {
                for (int k = 0; k < num; k++) {
                    if(j == k) continue;

                    result = isPalindrome(word[j] + word[k]);
                    if(!result.equals("0")) {
                        sb.append(result).append("\n");
                        break outer;
                    }
                }
                if(j == num - 1) sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    static String isPalindrome(String words) {
        for (int i = 0; i < words.length() / 2; i++) {
            if(words.charAt(i) != words.charAt(words.length() - i - 1)){
                return "0";
            }
        }
        return words;
    }
}