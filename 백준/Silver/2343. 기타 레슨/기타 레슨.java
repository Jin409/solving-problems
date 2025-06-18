import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int[] numbers;
    private static int m;
    private static List<Integer> answers;

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

        if (m == 1) {
            System.out.println(sum);
            return;
        }

        answers = new ArrayList<>();
        solve(maxValue, sum);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i) < answer) {
                answer = answers.get(i);
            }
        }

        System.out.println(answer);
    }

    private static void solve(int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;

        boolean isValid = true;
        for (int number : numbers) {
            if (number > middle) {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            solve(middle + 1, end);
            return;
        }

        int tempSum = 0;
        int count = 1;
        for (int i = 0; i < numbers.length; i++) {
            // 새로운 카운트로 셈
            if (tempSum + numbers[i] > middle) {
                count++;
                tempSum = numbers[i];
                continue;
            }

            tempSum += numbers[i];
        }

        if (count > m) {
            solve(middle + 1, end);
        }

        if (count <= m) {
            answers.add(middle);
            solve(start, middle);
        }
    }
}

