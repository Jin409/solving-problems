import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int[][] matrix;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(s[j]);
                matrix[i][j] = num;
            }
        }

        solve(0, N, 0, N);

        System.out.println(sb.toString());
    }

    public static void solve(int startX, int endX, int startY, int endY) {
        if (startX >= N || startY >= N) {
            return;
        }

        if (matchesCondition(startX, endX, startY, endY)) {
            int number = matrix[startX][startY];
            sb.append(number);
            return;
        }

        int size = endX - startX;
        int divider = size / 2;

        sb.append("(");

        solve(startX, startX + divider, startY, startY + divider);
        solve(startX, startX + divider, startY + divider, startY + divider * 2);
        solve(startX + divider, startX + divider * 2, startY, startY + divider);
        solve(startX + divider, startX + divider * 2, startY + divider, startY + divider * 2);

        sb.append(")");
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
