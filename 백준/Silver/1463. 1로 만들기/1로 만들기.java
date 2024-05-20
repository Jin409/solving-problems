
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 3으로 나눠 떨어지면 3으로 나눈다.
    // 2로 나눠 떨어지면 2로 나눈다.
    // 1을 뺀다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i > 0; i--) {
            dp[i] = dp[i + 1] + 1;
            if (i * 3 <= n) {
                dp[i] = Math.min(dp[i * 3] + 1, dp[i]);
            }
            if (i * 2 <= n) {
                dp[i] = Math.min(dp[i], dp[i * 2] + 1);
            }
        }

        System.out.println(dp[1]);
    }

}

