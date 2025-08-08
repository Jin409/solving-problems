import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");

        int[] numbers = new int[n + 1];
        for (int i = 0; i < n; i++) {
            numbers[i + 1] = Integer.parseInt(s[i]);
        }

        int[] results = new int[n + 1];
        results[1] = numbers[1];

        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                results[i] = results[i - 1] + numbers[i];
            }
        }

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");

            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            System.out.println(results[end] - results[start - 1]);
        }
    }
}
