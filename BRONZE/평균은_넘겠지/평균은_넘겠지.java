package BRONZE.평균은_넘겠지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            T--;
            String[] input = br.readLine().split(" ");
            int numberOfStudents = Integer.parseInt(input[0]);
            int[] scores = new int[numberOfStudents];

            for (int i = 0; i < numberOfStudents; i++) {
                scores[i] = Integer.parseInt(input[i + 1]);
            }

            OptionalDouble average = Arrays.stream(scores).average();
            int answer = 0;

            for (int score : scores) {
                if (score > average.getAsDouble()) {
                    answer++;
                }
            }
            System.out.printf("%.3f%%\n", (double) answer / numberOfStudents * 100);

        }

    }

}
