import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int height = Integer.parseInt(br.readLine());

        int size = 0;
        for (int i = 0; i <= height; i++) {
            size += i;
        }

        int[][] triangle = new int[height][size];

        for (int i = 0; i < height; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                triangle[i][j] = Integer.parseInt(s[j]);
            }
        }

        if (height > 1) {
            triangle[1][0] = triangle[0][0] + triangle[1][0];
            triangle[1][1] = triangle[0][0] + triangle[1][1];
        }

        for (int i = 2; i < height; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
                    continue;
                }
                if (j == (triangle[i].length - 1)) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
                    continue;
                }

                triangle[i][j] = Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]) + triangle[i][j];
            }
        }

        int result = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                result = Math.max(result, triangle[i][j]);
            }
        }

        System.out.print(result);
    }
}
