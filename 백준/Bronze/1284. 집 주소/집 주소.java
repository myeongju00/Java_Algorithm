import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int count = 0;
			
			String s = sc.next();
			
			if(s.equals("0")) System.exit(0);
			for(int i=0;i<s.length();i++) {
				String a = s.substring(i,i+1);
				
				if(a.equals("1")) count+=3;
				else if(a.equals("0")) count+=5;
				else count+=4;
			}
			
			System.out.println(count+1);
		}
		
	}
}