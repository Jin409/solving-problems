import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] results = new int[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            results[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 9) {
                    results[i][j] = results[i - 1][j - 1];
                    continue;
                }

                if (j == 0) {
                    results[i][j] = results[i - 1][j + 1];
                    continue;
                }

                results[i][j] = (results[i - 1][j - 1] + results[i - 1][j + 1]) % 1_000_000_000;
            }
        }

        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + results[n][i]) % 1_000_000_000;
        }
        System.out.print(result);
    }
}
