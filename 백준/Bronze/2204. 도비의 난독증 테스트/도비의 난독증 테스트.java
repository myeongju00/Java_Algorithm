import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				break;
			}
			
			List<String> list = new ArrayList<>();
			
			for(int i = 0; i < num; i++) {
				list.add(br.readLine());
			}
			
			Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.toLowerCase().compareTo(o2.toLowerCase());
				}
				
			});
			
			System.out.println(list.get(0));
		}
	}
}