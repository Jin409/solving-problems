import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    numbers.add(i * 100 + j * 10 + k);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");

            int comparedNumber = Integer.parseInt(s[0]);
            int strikeCount = Integer.parseInt(s[1]);
            int ballCount = Integer.parseInt(s[2]);

            numbers = check(numbers, strikeCount, ballCount, comparedNumber);
        }

        System.out.println(numbers.size());
    }

    public static List<Integer> check(List<Integer> numbers, int comparedStrikeCount, int comparedBallCount,
                                      int comparedNumber) {

        List<Integer> candidateNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 0) {
                continue;
            }

            int strikeCount = 0;
            int ballCount = 0;

            String[] parsedNumber = String.valueOf(numbers.get(i)).split("");
            String[] parsedComparedNumber = String.valueOf(comparedNumber).split("");

            for (int j = 0; j < 3; j++) {
                if (parsedNumber[j].equals(parsedComparedNumber[j])) {
                    strikeCount++;
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (parsedNumber[j].equals(parsedComparedNumber[k])) {
                        ballCount++;
                    }
                }
            }

            if (strikeCount == comparedStrikeCount && ballCount == comparedBallCount) {
                candidateNumbers.add(numbers.get(i));
            }
        }

        return candidateNumbers;
    }
}
