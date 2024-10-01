

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] data = new int[n][m];
        int[][] distances = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.toCharArray()[j];

                if (c == '1') {
                    data[i][j] = 1;
                } else {
                    data[i][j] = 0;
                }
            }
        }

        Queue<List<Integer>> q = new LinkedList<>();
        data[0][0] = 0;
        distances[0][0] = 1;
        q.add(List.of(0, 0));

        while (!q.isEmpty()) {
            List<Integer> top = q.poll();
            int a = top.get(0);
            int b = top.get(1);
            data[a][b] = 0;
            int distance = distances[a][b];
            
            if (isValid(a - 1, b, n, m) && data[a - 1][b] == 1) {
                distances[a - 1][b] = Math.min(distance + 1, distances[a - 1][b]);
                data[a - 1][b] = 0;
                q.add(List.of(a - 1, b));
            }

            if (isValid(a, b + 1, n, m) && data[a][b + 1] == 1) {
                distances[a][b + 1] = Math.min(distance + 1, distances[a][b + 1]);
                data[a][b + 1] = 0;
                q.add(List.of(a, b + 1));
            }

            if (isValid(a + 1, b, n, m) && data[a + 1][b] == 1) {
                distances[a + 1][b] = Math.min(distances[a + 1][b], distance + 1);
                data[a + 1][b] = 0;
                q.add(List.of(a + 1, b));
            }

            if (isValid(a, b - 1, n, m) && data[a][b - 1] == 1) {
                distances[a][b - 1] = Math.min(distances[a][b - 1], distance + 1);
                data[a][b - 1] = 0;
                q.add(List.of(a, b - 1));
            }
        }

        System.out.println(distances[n - 1][m - 1]);
    }

    private static boolean isValid(int a, int b, int n, int m) {
        return a < n && a >= 0 && b < m && b >= 0;
    }
}