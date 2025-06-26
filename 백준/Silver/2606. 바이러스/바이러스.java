import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] map;
    private static int[] visited;

    private static int computerCount;

    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerCount = Integer.parseInt(br.readLine());
        map = new int[computerCount + 1][computerCount + 1]; // 1부터 사용하도록 하기
        visited = new int[computerCount + 1];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int first = Integer.parseInt(s[0]);
            int second = Integer.parseInt(s[1]);

            map[first][second] = 1;
            map[second][first] = 1;
        }

        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int x) {
        int[] connect = map[x];
        visited[x] = 1;

        for (int i = 1; i <= computerCount; i++) {
            if (i == x) {
                continue;
            }

            if (connect[i] == 1 && visited[i] != 1) {
                map[x][i] = 0;
                map[i][x] = 0;
                answer++;
                dfs(i);
            }
        }
    }
}
