import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        char[][] board = new char[5][15];


        for(int i = 0; i < 5; i++) {
            char[] str = br.readLine().toCharArray();
            for(int j = 0; j < str.length; j++) {
                board[i][j] = str[j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(board[j][i] != '\0') {
                    sb.append(board[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}