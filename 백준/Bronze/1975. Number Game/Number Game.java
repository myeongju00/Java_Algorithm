import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			for(int j = 2; j <= N; j++) {
				int val = N;
				while(true) {
					if(val % j != 0) {
						break;
					}
					count++;
					val /= j;
				}
			}
			System.out.println(count);
		}
	}
}