
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[10];
        int n = Integer.parseInt(br.readLine());

        // 개수 파악
        while (n > 0) {
            nums[n % 10] += 1;
            n = n / 10;
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i == 6 || i == 9) {
                continue;
            }
            ans = Math.max(ans, nums[i]);
        }

        if ((nums[6] + nums[9]) % 2 == 1) {
            ans = Math.max(ans, (nums[6] + nums[9]) / 2 + 1);
        } else {
            ans = Math.max(ans, (nums[6] + nums[9]) / 2);
        }

        System.out.println(ans);
    }
}
