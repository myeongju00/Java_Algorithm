import java.io.*;
import java.util.Arrays;
 
class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int N = Integer.parseInt(br.readLine());
        int i, j, k;
        char[][] arr = new char[N][N];
        int[] result = new int[N]; 
        int[][] mark = new int[N][N]; 
        String s;
        for (i = 0; i < N; i++) {
            s = br.readLine();
            for (j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
 
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (arr[i][j] == 'Y') { 
                    if (mark[i][j] == 0) {
                        result[i]++; 
                        mark[i][j] = 1; 
                    }
                    for (k = 0; k < N; k++) { 
                        if (arr[j][k] == 'Y' && mark[i][k] == 0 && i != k) { 
                            result[i]++;
                            mark[i][k] = 1; 
                        }
                    }
                }
            }
        }
 
        Arrays.sort(result);
        bw.write(String.valueOf(result[N - 1])); 
        bw.flush();
    }
}