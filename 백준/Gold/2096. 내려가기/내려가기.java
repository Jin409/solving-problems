import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] numbers = new int[n][3];
        int[][] maxAnswers = new int[n][3];
        int[][] minAnswers = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                numbers[i][j] = Integer.parseInt(s[j]);
            }
        }

        maxAnswers[0][0] = numbers[0][0];
        maxAnswers[0][1] = numbers[0][1];
        maxAnswers[0][2] = numbers[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxAnswers[i][j] = numbers[i][j] + Math.max(maxAnswers[i - 1][j], maxAnswers[i - 1][j + 1]);
                }
                if (j == 1) {
                    int maxValue = Math.max(maxAnswers[i - 1][j - 1], maxAnswers[i - 1][j]);
                    maxValue = Math.max(maxValue, maxAnswers[i - 1][j + 1]);
                    maxAnswers[i][j] = maxValue + numbers[i][j];
                }
                if (j == 2) {
                    maxAnswers[i][j] = numbers[i][j] + Math.max(maxAnswers[i - 1][j], maxAnswers[i - 1][j - 1]);
                }
            }
        }

        minAnswers[0][0] = numbers[0][0];
        minAnswers[0][1] = numbers[0][1];
        minAnswers[0][2] = numbers[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    minAnswers[i][j] = numbers[i][j] + Math.min(minAnswers[i - 1][j], minAnswers[i - 1][j + 1]);
                }
                if (j == 1) {
                    int minValue = Math.min(minAnswers[i - 1][j - 1], minAnswers[i - 1][j]);
                    minValue = Math.min(minValue, minAnswers[i - 1][j + 1]);
                    minAnswers[i][j] = minValue + numbers[i][j];
                }
                if (j == 2) {
                    minAnswers[i][j] = numbers[i][j] + Math.min(minAnswers[i - 1][j], minAnswers[i - 1][j - 1]);
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            maxValue = Math.max(maxAnswers[n - 1][i], maxValue);
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            minValue = Math.min(minAnswers[n - 1][i], minValue);
        }

        System.out.println(maxValue + " " + minValue);
    }
}
