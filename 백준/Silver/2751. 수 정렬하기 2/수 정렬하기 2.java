import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sorted = new int[n];

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        sort(numbers, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(numbers[i]);
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

    private static void sort(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;

        sort(numbers, start, middle);
        sort(numbers, middle + 1, end);
        merge(start, end, numbers);
    }
}

