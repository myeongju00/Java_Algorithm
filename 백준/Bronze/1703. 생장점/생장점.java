import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //나무의 나이 입력
			if(a == 0){
				break;
			}
			int result = 1;
			for(int i = 0; i< a ; i++){
				int n = Integer.parseInt(st.nextToken()); //splitting factor 수
				int g = Integer.parseInt(st.nextToken()); //가지치기 한 수
				result = result * n - g; 
			}
			System.out.println(result);
		}

	}

}