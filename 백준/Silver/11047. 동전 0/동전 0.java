import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int target = Integer.parseInt(s[1]);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] price = new int[target + 1];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    price[i] = Math.min(price[i - coin] + 1, price[i]);
                }
            }
        }

        System.out.print(price[target]);
    }
}
