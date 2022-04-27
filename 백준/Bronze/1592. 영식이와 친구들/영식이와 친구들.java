import java.util.*;

public class Main {
	static int N; 
	static int M; 
	static int L; 
	static int[] friend; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  
		M = sc.nextInt();
		L = sc.nextInt();

		friend = new int[N + 1]; //친구 ArrayList		
		int count = 0; //공 던진 횟수
		
		friend[1] = 1;
		int index = 1;
		while(true) {
			//현재 배열의 인덱스 위치의 값이 M이라면 끝
			if(friend[index] == M) break;
			
			if(friend[index] % 2 == 1) index = index + L; // 시계방향으로 L만큼 공 이동
			else index = index - L; //반시계방향으로 L만큼 공 이동
			
			if(index > N) index %= N; //배열을 벗어날 때 Index + L;
			else if(index < 1) index += N; //배열을 벗어날 때 Index - L;
			
			friend[index]++;
			count++;
		}
		System.out.println(count);
	}
}