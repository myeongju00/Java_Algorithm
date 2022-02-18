import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, mul = 1;

        int[] num = new int[10];
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        mul = a * b * c;
        String str = Integer.toString(mul);

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            num[tmp - '0']++;
        }

        for(int i = 0; i < 10; i++)
            System.out.println(num[i]);
    }
}