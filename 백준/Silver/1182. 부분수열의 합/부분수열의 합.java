import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int N;
    private static int S;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        int[] numbers = new int[N];
        String[] rawNumbers = scanner.nextLine().split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(rawNumbers[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        solve(numbers, 0, 0, new ArrayList<>(), result);

        System.out.println(result.size());
    }

    private static void solve(int[] numbers, int sum, int index, List<Integer> temp, List<List<Integer>> result) {
        if (index == N) {
            if (sum == S && !temp.isEmpty()) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        temp.add(numbers[index]);
        solve(numbers, sum + numbers[index], index + 1, new ArrayList<>(temp), result);

        temp.remove(temp.size() - 1);
        solve(numbers, sum, index + 1, new ArrayList<>(temp), result);

    }

}
