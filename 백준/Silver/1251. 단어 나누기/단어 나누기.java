import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<String> list = new ArrayList<>();
	static String str;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		String[] st = new String[3];

		for(int i = 1; i < str.length() - 1; ++i) {
			for(int j = i + 1; j < str.length(); ++j) {
				st[0] = str.substring(0, i);
				st[1] = str.substring(i, j);
				st[2] = str.substring(j, str.length());

				StringBuffer sb = new StringBuffer();

				for(int k = 0; k < 3; ++k){
					for(int l = st[k].length() - 1; l >= 0; --l){
						sb.append(Character.toString(st[k].charAt(l)));
					}
				}
				
				list.add(sb.toString());
				
				sb.setLength(0);
			}    
		}

		Collections.sort(list); //정렬

		System.out.println(list.get(0));
	}
}