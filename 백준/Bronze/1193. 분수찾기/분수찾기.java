import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
 
		int cross_count = 1, prev_count_sum = 0;
 
		while (true) {
			// 직전 대각선 누적합 + 해당 대각선 개수 이용한 범위 판별
			if (N <= prev_count_sum + cross_count) {			
				if (cross_count % 2 == 1) {	// 대각선의 개수가 홀수라면 
					System.out.print((cross_count - (N - prev_count_sum - 1)) + "/" + (N - prev_count_sum));
					break;
				} 
				
				else {
					// 홀수일 때의 출력을 반대로 
					System.out.print((N - prev_count_sum) + "/" + (cross_count - (N - prev_count_sum - 1)));
					break;
				}
 
			} else {
				prev_count_sum += cross_count;
				cross_count++;
			}
		}
	}
}