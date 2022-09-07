import java.util.Arrays;
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] testArr = new int[t];
		for(int i =0; i<testArr.length; i++){
			int k = sc.nextInt();
			testArr[i] = k;
		}
		int[] fiboArr = new int[45];
		fiboArr[0] = 1;
		fiboArr[1] = 1;
		for(int i=2; i<fiboArr.length; i++){
			fiboArr[i] = fiboArr[i-2] + fiboArr[i-1];
		}
		for(int i=0; i<testArr.length; i++){
			int compData = testArr[i];
			int[] printArr = new int[45];
			int count = 0;
			for(int j = 44; j>=0; j--){
				if(fiboArr[j]<=compData){
					printArr[count] = fiboArr[j];
					compData -= fiboArr[j];
					count++;
					}
				}
			for(int o = 0; o<printArr.length; o++){
				Arrays.sort(printArr);
				if(printArr[o]!=0){
					System.out.println(printArr[o]);
				}
			}
		}
	}
}