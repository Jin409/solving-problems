import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] rawNumbers = br.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(rawNumbers[i]);
        }
        Arrays.sort(numbers);

        int m = Integer.parseInt(br.readLine());
        String[] rawTargets = br.readLine().split(" ");
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(rawTargets[i]);
        }

        for (int target : targets) {
            boolean existed = isExisted(numbers, target);
            if (existed) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean isExisted(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (numbers[middle] == target) {
                return true;
            }

            if (numbers[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return false;
    }
}
