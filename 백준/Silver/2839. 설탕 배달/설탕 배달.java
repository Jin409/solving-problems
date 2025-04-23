import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[n + 1];
        Arrays.fill(arr, 0);

        if (n >= 3) {
            arr[3] = 1;
        }
        if (n >= 5) {
            arr[5] = 1;
        }

        for (int i = 6; i <= n; i++) {
            if (arr[i - 5] != 0 && arr[i - 3] != 0) {
                arr[i] = Math.min(arr[i - 5] + 1, arr[i - 3] + 1);
                continue;
            }

            if (arr[i - 5] != 0) {
                arr[i] = arr[i - 5] + 1;
                continue;
            }

            if (arr[i - 3] != 0) {
                arr[i] = arr[i - 3] + 1;
            }
        }

        if (arr[n] == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(arr[n]);
    }
}
