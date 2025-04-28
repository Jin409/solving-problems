import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> VOWELS = List.of("a", "e", "i", "o", "u");

    private static int L;
    private static int C;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        L = Integer.parseInt(input[0]); // 암호의 길이
        C = Integer.parseInt(input[1]);

        String[] alphabets = Arrays.stream(scanner.nextLine().split(" ")).sorted().toArray(String[]::new);

        List<List<String>> result = new ArrayList<>();
        solve(0, alphabets, new ArrayList<>(), result);

        for (List<String> row : result) {
            for (String word : row) {
                System.out.print(word);
            }
            System.out.println();
        }
    }

    private static void solve(int index, String[] alphabets, List<String> temp, List<List<String>> result) {
        if (index == C) {
            if (matchesCondition(temp)) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        temp.add(alphabets[index]);
        solve(index + 1, alphabets, new ArrayList<>(temp), result);

        temp.remove(temp.size() - 1);
        solve(index + 1, alphabets, new ArrayList<>(temp), result);

    }

    private static boolean matchesCondition(List<String> temp) {
        int vowelCount = 0;

        for (String s : temp) {
            if (VOWELS.contains(s)) {
                vowelCount++;
            }
        }

        return vowelCount >= 1 && temp.size() - vowelCount >= 2 && temp.size() == L;
    }

}
