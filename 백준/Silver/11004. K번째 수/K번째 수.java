import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 개수
        int targetIndex = Integer.parseInt(s[1]);
        sorted = new int[n];

        String[] rawNumbers = br.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(rawNumbers[i]);
        }

        solve(0, n - 1, numbers);

        System.out.println(numbers[targetIndex - 1]);
    }

    private static void merge(int start, int end, int[] list) {
        int middle = (start + end) / 2;
        int left = start;
        int right = middle + 1;
        int index = left;

        while (left <= middle && right <= end) {
            if (list[left] <= list[right]) {
                sorted[index] = list[left];
                left++;
            } else { // 만약 오른쪽이 더 작다면
                sorted[index] = list[right];
                right++;
            }

            index++;
        }

        while (left <= middle) {
            sorted[index] = list[left];
            left++;
            index++;
        }

        while (right <= end) {
            sorted[index] = list[right];
            right++;
            index++;
        }

        for (int i = start; i <= end; i++) {
            list[i] = sorted[i];
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
