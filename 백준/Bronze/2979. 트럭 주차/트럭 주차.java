import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        // 도착한 시간과 떠난 시간
        int[][] cars = new int[3][100 + 1];

        for (int i = 0; i < 3; i++) {
            s = br.readLine().split(" ");
            int arriveAt = Integer.parseInt(s[0]);
            int leaveAt = Integer.parseInt(s[1]);

            for (int j = arriveAt; j < leaveAt; j++) {
                cars[i][j] = 1;
            }
        }

        int result = 0;

        for (int i = 1; i <= 100; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (cars[j][i] == 1) {
                    count++;
                }
            }

            if (count == 1) {
                result += a;
            }

            if (count == 2) {
                result += b * 2;
            }

            if (count == 3) {
                result += c * 3;
            }
        }

        System.out.print(result);

    }
}
