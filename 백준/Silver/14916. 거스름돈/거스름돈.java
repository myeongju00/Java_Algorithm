import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());  //거스름돈
		int cnt = 0;  //동전 개수
				
		while(N >= 0) {
			if (N % 5 == 0) {
				System.out.println(cnt + (N / 5));
				break;
			}
			N -= 2;
			cnt += 1;
		}
		if(N < 0) {
			System.out.println(-1);
		}
	}

}