import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            for(int j = a - i; j > 0; j--) {
                System.out.print(" ");
            }

            for(int j = i; j > 0; j--) {
                System.out.print("*");
            }

            System.out.println("");
        }
    }
}