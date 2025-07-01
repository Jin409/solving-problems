import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int SIZE = 36;

    private static int[][] directions = {
            {-2, 1},
            {-2, -1},
            {2, -1},
            {2, 1},
            {1, 2},
            {-1, 2},
            {-1, -2},
            {1, -2},
    };
    private static List<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] orders = new String[SIZE];
        visited = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            orders[i] = br.readLine();
        }

        for (int i = 1; i < SIZE; i++) {
            String now = orders[i - 1];
            if (visited.contains(now)) {
                System.out.println("Invalid");
                return;
            }
            String next = orders[i];

            if (!isValid(now, next)) {
                System.out.println("Invalid");
                return;
            }

            visited.add(now);
        }

        if (visited.contains(orders[SIZE - 1])) {
            System.out.println("Invalid");
            return;
        }
        visited.add(orders[SIZE - 1]);

        String last = orders[SIZE - 1];
        if (isValid(last, orders[0])) {
            System.out.println("Valid");
            return;
        }

        System.out.println("Invalid");
    }

    private static boolean isValid(String location, String nextLocation) {
        String[] split = location.split("");
        String column = split[0];
        int row = Integer.parseInt(split[1]);

        List<String> results = new ArrayList<>();
        for (int[] direction : directions) {
            char newColumn = (char) (column.charAt(0) + direction[1]);
            int newRow = row + direction[0];

            if (newColumn < 'A' || newColumn > 'F' || newRow > 6 || newRow < 1) {
                continue;
            }

            String result = newColumn + String.valueOf(newRow);
            results.add(result);
        }

        for (String result : results) {
            if (result.equals(nextLocation)) {
                return true;
            }
        }
        return false;
    }
}
