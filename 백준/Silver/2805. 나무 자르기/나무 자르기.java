import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int targetLength;
    private static List<Long> answers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        targetLength = Integer.parseInt(s[1]); // 자르고 남은 나무의 높이의 합이 되어야 하는 수

        String[] rawWoods = br.readLine().split(" ");

        long[] woods = new long[n];
        for (int i = 0; i < n; i++) {
            woods[i] = Long.parseLong(rawWoods[i]);
        }

        long maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (woods[i] > maxLength) {
                maxLength = woods[i];
            }
        }

        answers = new ArrayList<>();
        solve(0, maxLength, woods);

        long maxAnswer = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (maxAnswer < answers.get(i)) {
                maxAnswer = answers.get(i);
            }
        }

        System.out.println(maxAnswer);
    }

    private static void solve(long left, long right, long[] woods) {
        if (left >= right) {
            return;
        }

        long middle = (left + right) / 2;

        long sum = 0;
        for (int i = 0; i < woods.length; i++) {
            if (woods[i] < middle) {
                continue;
            }

            sum += (woods[i] - middle);
        }

        if (sum == targetLength) {
            answers.add(middle);
        }

        if (sum < targetLength) {
            solve(left, middle, woods);
        }

        if (sum > targetLength) {
            answers.add(middle);
            solve(middle + 1, right, woods);
        }

    }
}

