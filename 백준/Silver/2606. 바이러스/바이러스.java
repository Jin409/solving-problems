
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static boolean[][] graph;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];
        ans = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
            graph[b][a] = true;
        }

        // 1번 노드가 직, 간접적으로 어떤 노드들과 연결되어 있는가
        visited[1] = true;
        dfs(1);
        System.out.println(ans);
    }

    public static void dfs(int v) {
        for (int i = 1; i <= n; i++) {
            if (graph[v][i] == true && visited[i] == false) { // 연결되어 있지만 아직 방문하지 않은 경우
                visited[i] = true;
                ans++;
                dfs(i);
            }
        }
    }
}
