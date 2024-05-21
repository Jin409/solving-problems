
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // 한번에 하나, 두개씩 오를 수 있음
        // 연속된 세개의 계단을 모두 밟으면 안된다
        // 마지막 도착 계단은 반드시 밟아야 한다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 계단의 개수
        dp = new int[n + 1];
        stairs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[1]);
        } else if (n == 2) {
            System.out.println(stairs[1] + stairs[2]);
        } else if (n == 3) {
            System.out.println(Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]));
        } else {
            dp[1] = stairs[1];
            dp[2] = stairs[1] + stairs[2];
            dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
            }

            System.out.println(dp[n]);

        }


    }

}
