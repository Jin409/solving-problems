import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int v = Integer.parseInt(s[2]);

        int day = (v - b - 1) / (a - b) + 1;
        System.out.println(day);

    }
}
