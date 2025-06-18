import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] numbers;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        String[] rawNumbers = br.readLine().split(" ");
        numbers = new int[n];
        int maxValue = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(rawNumbers[i]);
            sum += numbers[i];
            if (maxValue < numbers[i]) {
                maxValue = numbers[i];
            }
        }

        int answer = solve(maxValue, sum);
        System.out.println(answer);
    }

    private static int solve(int start, int end) {

        while (start < end) {
            int middle = (start + end) / 2;

            int tempSum = 0;
            int count = 1;
            for (int i = 0; i < numbers.length; i++) {
                if (tempSum + numbers[i] > middle) {
                    count++;
                    tempSum = numbers[i];
                    continue;
                }

                tempSum += numbers[i];
            }

            if (count > m) {
                start = middle + 1;
            }

            if (count <= m) {
                end = middle;
            }
        }

        return start;
    }
}

