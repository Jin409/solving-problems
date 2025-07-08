import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 돈을 최대한 많이 지불해서 카드를 사고자 한다.
        int n = Integer.parseInt(br.readLine());
        int[] prices = new int[n + 1];

        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            prices[i] = Integer.parseInt(s[i - 1]);
        }

        int[] result = new int[n + 1];
        result[1] = prices[1];

        for (int i = 2; i <= n; i++) {
            int maxPrice = 0;

            for (int j = 1; j <= i; j++) {
                maxPrice = Math.max(maxPrice, prices[j] + result[i - j]);
            }

            result[i] = maxPrice;
        }

        System.out.print(result[n]);
    }
}
