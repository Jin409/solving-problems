import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < c; i++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int[] numbers = new int[n];
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                numbers[j - 1] = Integer.parseInt(input[j]);
                sum += numbers[j - 1];
            }

            double average = (double) sum / n;

            int result = 0;
            for (int j = 0; j < n; j++) {
                if (numbers[j] > average) {
                    result++;
                }
            }

            System.out.printf("%.3f%%\n", (double) result / n * 100);
        }
    }
}
