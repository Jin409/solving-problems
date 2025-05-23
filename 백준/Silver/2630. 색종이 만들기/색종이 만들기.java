import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;

    private static final int BLUE_SIGN = 0;
    private static final int WHITE_SIGN = 1;

    private static int WHITE_COUNT = 0;
    private static int BLUE_COUNT = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] input = new int[N][N]; // 색종이

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(line[j]);
            }
        }

        solve(input, 0, 0, N);

        System.out.println(BLUE_COUNT);
        System.out.println(WHITE_COUNT);
    }

    private static void solve(int[][] input, int row, int col, int size) {

        int color = input[row][col];

        if (checkColor(input, row, col, color, size)) {
            if (color == BLUE_SIGN) {
                BLUE_COUNT++;
            } else {
                WHITE_COUNT++;
            }
            return;
        }

        size /= 2;

        solve(input, row, col, size);
        solve(input, row + size, col, size);
        solve(input, row, col + size, size);
        solve(input, row + size, col + size, size);
    }

    private static boolean checkColor(int[][] input, int row, int col, int colorSign, int size) {

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (input[i][j] != colorSign) {
                    return false;
                }
            }
        }

        return true;
    }
}
