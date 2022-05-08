import java.io.*;
import java.util.*;

class Main {  
  public static void main(String args[]) throws Exception { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // A, B
    String[] temp = br.readLine().split(" ");
    int A = Integer.parseInt(temp[0]);
    int B = Integer.parseInt(temp[1]);

    // 값을 담을 리스트
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 1; i <= 1000; i++) {
      for(int j = 0; j < i; j++) {
        list.add(i);
      }
    }

    // A부터 B까지의 합
    int result = 0;
    for(int i = A; i <= B; i++) {
      result += list.get(i - 1);
    }

    // 결과 값 출력
    System.out.println(result);
  }
}