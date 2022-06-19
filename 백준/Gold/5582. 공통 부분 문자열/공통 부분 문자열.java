import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int length_1 = str1.length;
        int length_2 = str2.length;

        int[][] dp = new int[length_1 + 1][length_2 + 1];

        int result = 0;
        for(int i = 1; i <= length_1; i++) {
            for(int j = 1; j <= length_2; j++) {
                // (i-1)번째 문자 == (j-1)번째 문자
                if(str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        System.out.println(result);
    }
}