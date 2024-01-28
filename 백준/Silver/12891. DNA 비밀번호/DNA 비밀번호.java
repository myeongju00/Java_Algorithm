import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static char[] arr;
    static int[] myArr = new int[4];
    static int[] countIndex = new int[4]; // A C G T
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            countIndex[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            add(i);
        }

        int result = 0;
        if(checkCount()) {
            result++;
        }

        int i = -1;
        for (int j = P; j < S; j++) {
            i = j - P;
            if (arr[i] == 'A') {
                myArr[0]--;
            } else if (arr[i] == 'C') {
                myArr[1]--;
            } else if (arr[i] == 'G') {
                myArr[2]--;
            } else if (arr[i] == 'T') {
                myArr[3]--;
            }

            add(j);

            if(checkCount()) {
                result++;
            }
        }
        sb.append(result);
        System.out.println(sb);
    }

    private static void add(int dna) {
        if (arr[dna] == 'A') {
            myArr[0]++;
        } else if (arr[dna] == 'C') {
            myArr[1]++;
        } else if (arr[dna] == 'G') {
            myArr[2]++;
        } else if (arr[dna] == 'T') {
            myArr[3]++;
        }
    }

    public static boolean checkCount() {
        for (int i = 0; i < 4; i++) {
            if (myArr[i] < countIndex[i]) {
                return false;
            }
        }
        return true;
    }
}