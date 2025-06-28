import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] map;
    private static int[][] distances;

    private static int[] up = {-1, 0};
    private static int[] down = {1, 0};
    private static int[] left = {0, -1};
    private static int[] right = {0, 1};

    private static int[][] movements = {up, down, left, right};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        map = new int[n + 1][m + 1];
        distances = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j + 1] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        solve();
        System.out.println(distances[n][m]);
    }

    private static boolean isInRange(int x, int y) {
        return x > 0 && x < map.length && y > 0 && y < map[0].length;
    }

    private static void solve() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 1});
        distances[1][1] = 1;
        map[1][1] = 0;

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            int topX = top[0];
            int topY = top[1];

            for (int[] movement : movements) {
                int dx = movement[0] + topX;
                int dy = movement[1] + topY;

                if (isInRange(dx, dy) && map[dx][dy] == 1) {
                    map[dx][dy] = 0;
                    distances[dx][dy] = distances[topX][topY] + 1;
                    queue.add(new int[]{dx, dy});
                }
            }
        }
    }
}
