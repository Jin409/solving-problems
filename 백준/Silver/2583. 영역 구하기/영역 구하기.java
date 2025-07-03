import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final int[][] DIRECTIONS =
            {
                    {-1, 0},
                    {1, 0},
                    {0, -1},
                    {0, 1}
            };

    private static final List<Integer> answers = new ArrayList<>();

    private static int[][] map;
    private static int m;
    private static int n;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        map = new int[m][n];

        for (int i = 0; i < k; i++) {
            s = br.readLine().split(" ");

            int firstX = Integer.parseInt(s[0]);
            int firstY = m - Integer.parseInt(s[1]);

            int secondX = Integer.parseInt(s[2]);
            int secondY = m - Integer.parseInt(s[3]);

            int minX = Math.min(firstX, secondX);
            int maxX = Math.max(firstX, secondX);

            int minY = Math.min(firstY, secondY);
            int maxY = Math.max(firstY, secondY);

            for (int j = minY; j < maxY; j++) {
                for (int u = minX; u < maxX; u++) {
                    map[j][u] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    count = 0;
                    dfs(i, j);
                    answers.add(count);
                }
            }
        }

        System.out.println(answers.size());
        Collections.sort(answers);
        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }

    private static boolean inRange(int x, int y) {
        return x < m && x >= 0 && y < n && y >= 0;
    }

    private static void dfs(int x, int y) {
        count++;

        for (int[] direction : DIRECTIONS) {
            int dx = x + direction[0];
            int dy = y + direction[1];

            if (inRange(dx, dy) && map[dx][dy] == 0) {
                map[dx][dy] = 1;
                dfs(dx, dy);
            }
        }
    }
}
