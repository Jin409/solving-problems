import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int ROW_SIZE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int columnSize = Integer.parseInt(br.readLine());
            int[][] stickers = new int[ROW_SIZE][columnSize];
            int[][] results = new int[ROW_SIZE][columnSize];

            for (int i = 0; i < ROW_SIZE; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < columnSize; j++) {
                    stickers[i][j] = Integer.parseInt(s[j]);
                }
            }

            results[0][0] = stickers[0][0];
            results[1][0] = stickers[1][0];

            if (columnSize >= 2) {
                results[0][1] = stickers[1][0] + stickers[0][1];
                results[1][1] = stickers[0][0] + stickers[1][1];
            }

            for (int column = 2; column < columnSize; column++) {
                for (int row = 0; row < ROW_SIZE; row++) {
                    if (row == 0) {
                        results[row][column] =
                                Math.max(results[1][column - 1], results[1][column - 2]) + stickers[row][column];
                    } else {
                        results[row][column] =
                                Math.max(results[0][column - 1], results[0][column - 2]) + stickers[row][column];
                    }
                }
            }

            int result = 0;
            for (int row = 0; row < ROW_SIZE; row++) {
                for (int column = 0; column < columnSize; column++) {
                    result = Math.max(result, results[row][column]);
                }
            }

            System.out.println(result);
        }
    }
}
