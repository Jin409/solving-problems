import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        sorted = new int[size];

        String[] rawNumbers = br.readLine().split(" ");
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(rawNumbers[i]);
        }

        sort(0, size - 1, numbers); // 숫자들을 정렬

        int result = 0;
        for (int i = 0; i < size; i++) {
            if (isGoodNumber(numbers, i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isGoodNumber(int[] numbers, int targetIndex) {
        int left = 0;
        int right = numbers.length - 1;
        int targetSum = numbers[targetIndex]; // 합이 되어야 하는 값

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == targetSum && left != targetIndex && right != targetIndex) {
                return true;
            }

            if (sum < targetSum) {
                left++;
            }

            if (sum > targetSum) {
                right--;
            }

            if (left == targetIndex) {
                left++;
            }

            if (right == targetIndex) {
                right--;
            }
        }

        return false;
    }

    private static void sort(int left, int right, int[] numbers) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        sort(left, middle, numbers);
        sort(middle + 1, right, numbers);
        merge(left, right, numbers);
    }

    private static void merge(int start, int end, int[] numbers) {
        int middle = (start + end) / 2;
        int left = start;
        int right = middle + 1;
        int index = start;

        while (left <= middle && right <= end) {
            if (numbers[left] < numbers[right]) {
                sorted[index++] = numbers[left++];
            } else {
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
}

