import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] answers = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }

        int current = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < n; i++) {
            current = Math.max(numbers[i], current + numbers[i]);
            max = Math.max(max, current);
        }

        System.out.print(max);
    }
}
