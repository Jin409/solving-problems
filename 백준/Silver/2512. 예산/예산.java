import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static long[] budgets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCount = Integer.parseInt(br.readLine());

        budgets = new long[cityCount];

        String[] s = br.readLine().split(" ");
        long sum = 0;
        long maxBudget = 0;
        for (int i = 0; i < cityCount; i++) {
            budgets[i] = Long.parseLong(s[i]);
            if (budgets[i] > maxBudget) {
                maxBudget = budgets[i];
            }
            sum += budgets[i];
        }

        long sumOfBudget = Long.parseLong(br.readLine());

        if (sumOfBudget >= sum) {
            System.out.println(maxBudget);
            return;
        }

        long left = 0;
        long right = maxBudget;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long tempSum = 0;
            for (int i = 0; i < cityCount; i++) {
                if (tempSum > sumOfBudget) {
                    break;
                }

                if (budgets[i] <= mid) {
                    tempSum += budgets[i];
                } else {
                    tempSum += mid;
                }
            }

            if (tempSum <= sumOfBudget) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
