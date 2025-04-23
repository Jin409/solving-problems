import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            if (!flag) {
                break;
            }

            if (Math.abs(100 - sum) >= Math.abs(100 - (sum + numbers[i]))) {
                sum += numbers[i];
                continue;
            }

            flag = false;

        }

        System.out.println(sum);
    }
}
