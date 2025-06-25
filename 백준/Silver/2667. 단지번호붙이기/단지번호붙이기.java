import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    private static int[][] map;

    private static int n;

    private static List<Integer> answer;

    private static final int[] up = {-1, 0};
    private static final int[] down = {1, 0};
    private static final int[] left = {0, -1};
    private static final int[] right = {0, 1};

    private static final int[][] movements = {up, down, left, right};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                bfs(i, j);
            }
        }

        System.out.println(answer.size());
        answer.stream().sorted().forEach(System.out::println);
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static void bfs(int x, int y) {
        Stack<List<Integer>> stack = new Stack<>();
        stack.add(List.of(x, y));

        int count = 0;

        while (!stack.isEmpty()) {
            List<Integer> top = stack.pop();
            Integer topX = top.get(0);
            Integer topY = top.get(1);

            if (map[topX][topY] == 0) {
                continue;
            }

            map[topX][topY] = 0;
            count++;

            for (int[] movement : movements) {
                int dx = movement[0] + topX;
                int dy = movement[1] + topY;

                if (!isInRange(dx, dy)) {
                    continue;
                }

                if (map[dx][dy] == 0) {
                    continue;
                }

                stack.add(List.of(dx, dy));
            }
        }

        answer.add(count);
    }
}
