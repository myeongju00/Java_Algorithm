import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 테스트 케이스의 수가 정해져 있지 않기 때문에 무한루프
		while (true) {
			int N = Integer.parseInt(br.readLine());
			// 0이 입력되면 무한루프 종료
			if (N == 0)
				break;

			// 삼항연산자로 결과값을 저장
			String S = (N % n == 0) ? N + " is a multiple of " + n + "." : N + " is NOT a multiple of " + n + ".";

			System.out.println(S);
		}
	}
}