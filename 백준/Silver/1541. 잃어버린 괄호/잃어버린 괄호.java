import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정 
		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
 
		while (sub.hasMoreTokens()) {
			int temp = 0;
			// 뺄셈으로 나뉜 토큰을 덧셈으로 분리
			StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
			while (add.hasMoreTokens()) {
				temp += Integer.parseInt(add.nextToken());
			}
			
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
}