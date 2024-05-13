
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int[][] graph; // 방문하고 나서는 0으로 바꾸기
    static PriorityQueue<Integer> ans = new PriorityQueue<>();
    static int size;
    static List<List<Integer>> directions = List.of( // 동, 서, 남, 북
            List.of(0, 1),
            List.of(0, -1),
            List.of(1, 0),
            List.of(-1, 0)
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == '0') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                    size = 1;
                    move(i, j);
                    ans.add(size);
                }
            }
        }
        System.out.println(ans.size());
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.println(ans.poll());
        }

    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void move(int x, int y) {
        for (List<Integer> direction : directions) {
            int newX = x + direction.get(0);
            int newY = y + direction.get(1);

            // 동, 서, 남, 북으로 이동
            if (valid(newX, newY) && graph[newX][newY] == 1) {
                graph[newX][newY] = 0; // 이미 방문했다는 사인
                size++;
                move(newX, newY);
            }
        }
    }
}
