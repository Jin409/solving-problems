

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dfs;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        dfs = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dfs[a][b] = 1;
            dfs[b][a] = 1;
        }

        isVisited[v] = true;
        dfs(v);

        for (int i = 0; i <= n; i++) {
            isVisited[i] = false;
        }

        System.out.println();

        bfs(v);
    }

    public static void dfs(int index) {
        System.out.print(index + " ");

        for (int i = 1; i < dfs[index].length; i++) {

            if (i == index) {
                continue;
            }

            if (!isVisited[i] && dfs[index][i] == 1) {
                isVisited[i] = true;
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while (!q.isEmpty()) {
            int top = q.poll();

            if (!isVisited[top]) {
                System.out.print(top + " ");
            }

            isVisited[top] = true;

            for (int i = 1; i < dfs[top].length; i++) {
                if (i == top) {
                    continue;
                }

                if (!isVisited[i] && dfs[top][i] == 1) {
                    q.add(i);
                }
            }
        }
    }
}