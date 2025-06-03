import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int[][] matrix;

    private static int MINUS_ONE = 0;
    private static int ONE = 0;
    private static int ZERO = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(s[j]);
                matrix[i][j] = num;
            }
        }

        solve(0, N, 0, N);

        System.out.println(MINUS_ONE);
        System.out.println(ZERO);
        System.out.println(ONE);
    }

    private static void solve(int startX, int endX, int startY, int endY) {
        if (startX >= N || startY >= N || endX > N || endY > N) {
            return;
        }

        int num = matrix[startX][startY];

        if (matchesCondition(startX, endX, startY, endY)) {
            if (num == 1) {
                ONE++;
                return;
            }
            if (num == -1) {
                MINUS_ONE++;
                return;
            }
            if (num == 0) {
                ZERO++;
                return;
            }
        }

        int devider = (endX - startX) / 3;

        solve(startX, startX + devider, startY, startY + devider);
        solve(startX, startX + devider, startY + devider, startY + devider * 2);
        solve(startX, startX + devider, startY + devider * 2, startY + devider * 3);

        solve(startX + devider, startX + devider * 2, startY, startY + devider);
        solve(startX + devider, startX + devider * 2, startY + devider, startY + devider * 2);
        solve(startX + devider, startX + devider * 2, startY + devider * 2, startY + devider * 3);

        solve(startX + devider * 2, startX + devider * 3, startY, startY + devider);
        solve(startX + devider * 2, startX + devider * 3, startY + devider, startY + devider * 2);
        solve(startX + devider * 2, startX + devider * 3, startY + devider * 2, startY + devider * 3);

    }

    private static boolean matchesCondition(int startX, int endX, int startY, int endY) {
        int num = matrix[startX][startY];

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (matrix[i][j] != num) {
                    return false;
                }
            }
        }

        return true;
    }
}
