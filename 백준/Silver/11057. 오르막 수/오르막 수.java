import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] numbers = new int[n + 1][10];
        numbers[1] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // 주의, 0으로 시작 가능!

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                int result = 0;
                for (int k = j; k <= 9; k++) {
                    result = (result + numbers[i - 1][k]) % 10_007;
                }
                numbers[i][j] = result;
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + numbers[n][i]) % 10_007;
        }
        System.out.print(answer);
    }
}
