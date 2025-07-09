import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];

        numbers[1] = 1;
        if (n >= 2) {
            numbers[2] = 2;
        }
        if (n >= 3) {
            numbers[3] = 3;
        }

        for (int i = 4; i <= n; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                numbers[i] = 1;
                continue;
            }

            int minValue = Integer.MAX_VALUE;

            for (int j = 1; j < i; j++) {
                minValue = Math.min(minValue, numbers[j] + numbers[i - j]);
            }

            numbers[i] = minValue;
        }

        System.out.print(numbers[n]);
    }
}
