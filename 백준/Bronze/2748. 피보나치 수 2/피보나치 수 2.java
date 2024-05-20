import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 2) {
            if (n <= 1) {
                System.out.println(n);
            } else {
                System.out.println(1L);
            }
        } else {
            Long[] dp = new Long[n + 1];
            dp[0] = 0L;
            dp[1] = 1L;
            dp[2] = 1L;

            for (int i = 3; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];

            }
            System.out.println(dp[n]);
        }

    }
}
