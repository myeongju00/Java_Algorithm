import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();

        for(int i = 1; i <= a; i++) {
            for(int j = 1; j < i; j ++) System.out.print(" ");
            for(int j = 2 * a - (2 * i - 1); j > 0; j --) System.out.print("*");

            System.out.println("");
        }
    }
}
