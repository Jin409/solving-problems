import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] sorted;

    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sorted = new int[n];

        String[] rawNumbers = br.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(rawNumbers[i]);
        }

        int targetSum = Integer.parseInt(br.readLine());

        solve(0, n - 1, numbers); // 0~n-1 까지 정렬된 상태
        count(numbers, targetSum);
        System.out.println(result);
    }

    private static void count(int[] numbers, int targetSum) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == targetSum) {
                result++;
                right--;
                left++;
            }

            if (sum > targetSum) {
                right--;
            }

            if (sum < targetSum) {
                left++;
            }

        }

    }

    private static void merge(int start, int end, int[] numbers) {
        int middle = (start + end) / 2;
        int left = start;
        int right = middle + 1;
        int index = start;

        while (left <= middle && right <= end) {
            if (numbers[left] < numbers[right]) {
                sorted[index++] = numbers[left++];
            } else { // right 가 더 작은 경우
                sorted[index++] = numbers[right++];
            }
        }

        while (left <= middle) {
            sorted[index++] = numbers[left++];
        }

        while (right <= end) {
            sorted[index++] = numbers[right++];
        }

        for (int i = start; i <= end; i++) {
            numbers[i] = sorted[i];
        }
    }

    private static void solve(int start, int end, int[] numbers) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        solve(start, mid, numbers);
        solve(mid + 1, end, numbers);
        merge(start, end, numbers);
    }
}
