import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int ans;
    static int m; // 가로
    static int n; // 세로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            T--;

            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph = new boolean[m][n];
            visited = new boolean[m][n];
            ans = 0;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = true;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == false && graph[i][j] == true) { // 방문하지 않은 경우
                        dfs(i, j);
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    public static boolean valid(int newX, int newY) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }

    public static void dfs(int x, int y) {
        // 사방으로 탐색
        // 1. 범위 내, 2. 연결된 경우, 3. 방문하지 않은 경우
        if (valid(x - 1, y) && graph[x - 1][y] && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            dfs(x - 1, y);
        }
        if (valid(x, y - 1) && graph[x][y - 1] && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            dfs(x, y - 1);
        }
        if (valid(x, y + 1) && graph[x][y + 1] && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            dfs(x, y + 1);
        }
        if (valid(x + 1, y) && graph[x + 1][y] && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            dfs(x + 1, y);
        }
    }
}
