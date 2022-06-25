import java.lang.*;
import java.io.*;

class Main {

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            // 입력 받기
            String tmp = br.readLine();

            // 종료 조건
            if (tmp.equals("0")) {
                break;
            }

            String[] num = tmp.split("");
            // 계산 하기
            testNum(num);
        }
    }
    
    static void testNum(String[] num) {
        int result = 0;
        for (String s : num) {
            result += Integer.parseInt(s);
        }
        
        if((result / 10) == 0) {
            // 결과가 나왔으므로 출력
            System.out.println(result);
        } else {
            testNum(String.valueOf(result).split(""));
        }
    }

}