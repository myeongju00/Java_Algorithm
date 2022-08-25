import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        int flag = 0;
        while (T.length() > S.length()) {
            if (T.charAt(T.length() - 1) == 'A') { //T의 끝자리가 A이면?
                T.delete(T.length() - 1, T.length()); //마지막 자리 지우기
            } else {
                T.delete(T.length() - 1, T.length());
                T.reverse();
            }


            if (T.length() == S.length()) {
                if (T.toString().equals(S.toString())) flag = 1;
                break;
            }
        }
        System.out.println(flag);
    }
}