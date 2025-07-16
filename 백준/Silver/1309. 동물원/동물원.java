import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] lions = new int[n + 1][3];

        lions[1] = new int[]{1, 1, 1};
        for (int i = 2; i <= n; i++) {
            lions[i][0] = (lions[i - 1][0] + lions[i - 1][1] + lions[i - 1][2]) % 9901;
            lions[i][1] = (lions[i - 1][0] + lions[i - 1][2]) % 9901;
            lions[i][2] = (lions[i - 1][0] + lions[i - 1][1]) % 9901;
        }

        System.out.print((lions[n][0] + lions[n][1] + lions[n][2]) % 9901);
    }
}
