import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] numbers = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] rawNumbers = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                numbers[i][j] = Integer.parseInt(rawNumbers[j - 1]);
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int index = 0; index < k; index++) {
            String[] s = br.readLine().split(" ");

            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int y = Integer.parseInt(s[3]);

            int result = 0;

            for (int index2 = i; index2 <= x; index2++) {
                for (int index3 = j; index3 <= y; index3++) {
                    result += numbers[index2][index3];
                }
            }

            System.out.println(result);
        }
    }
}
