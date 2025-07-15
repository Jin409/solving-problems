import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] results = new int[n + 1];
        results[1] = 1;

        if (n >= 2) {
            results[2] = 2;
        }

        if (n >= 3) {
            results[3] = 3;
        }

        for (int i = 4; i <= n; i++) {
            results[i] = (results[i - 1] + results[i - 2]) % 10_007;
        }

        System.out.print(results[n]);
    }
}
