import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] counts = new int[n];
        Arrays.fill(counts, 1);

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }

        for (int i = 1; i < n; i++) {
            int maxCount = 0;
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[i]) {
                    maxCount = Math.max(maxCount, counts[j]);
                }
            }
            counts[i] = maxCount + 1;
        }

        int maxNumber = 0;
        for (int i = 0; i < n; i++) {
            if (maxNumber < counts[i]) {
                maxNumber = counts[i];
            }
        }
        System.out.print(maxNumber);
    }
}
