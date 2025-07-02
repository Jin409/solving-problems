import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int v = Integer.parseInt(s[2]);

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(v);
        System.out.println();
        for (int i = 0; i <= n; i++) {
            visited[i] = false;
        }
        bfs(v);
    }

    private static void dfs(int x) {
        int[] connection = map[x];
        visited[x] = true;
        System.out.print(x + " ");

        for (int i = 1; i < connection.length; i++) {
            if (i == x) {
                continue;
            }
            if (connection[i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int top = q.poll();
            System.out.print(top + " ");
            int[] connection = map[top];

            for (int i = 1; i < connection.length; i++) {
                if (i == top) {
                    continue;
                }
                if (connection[i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

    }

}
