import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int aLen = a.length();
		int bLen = b.length();
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= bLen - aLen; i++) {	// b의 인덱스
			int count = 0;
			for(int j = 0; j < aLen; j++) {	// a의 인덱스
				char aChar = a.charAt(j);
				char bChar = b.charAt(i + j);
				if(aChar != bChar) {
					count++;
				}
				if(min < count) {
					break;
				}
			}
			min = Math.min(min, count);
		}
		System.out.println(min);
	}
}