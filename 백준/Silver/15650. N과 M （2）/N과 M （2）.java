import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int n = Integer.parseInt(input[0]); // 1 ~ n
        int m = Integer.parseInt(input[1]); // m 개로 이루어진 순열

        List<List<Integer>> totalResults = new ArrayList<>();
        solve(1, n, m, new ArrayList<>(List.of(1)), totalResults);
        solve(1, n, m, new ArrayList<>(), totalResults);

        for (List<Integer> totalResult : totalResults) {
            for (Integer number : totalResult) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static void solve(int now, int end, int maxSize, List<Integer> result, List<List<Integer>> totalResults) {
        if (result.size() == maxSize) {
            totalResults.add(new ArrayList<>(result));
            return;
        }

        for (int i = now + 1; i <= end; i++) {
            result.add(i);
            solve(i, end, maxSize, result, totalResults);
            result.remove(result.size() - 1);
        }
    }

}
