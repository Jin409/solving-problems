
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int sumOfDepth = 0;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 리프 노드 -> 루트 노드로 가는 데까지 총 합해서 짝수번이면 진다
        // 다시 말하자면, 루트 -> 리프로 가는 데까지 총 합해서 짝수번이면 진다
        dfs(1, 0);
        if (sumOfDepth % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }

    public static void dfs(int num, int depth) {
        visited[num] = true;
        List<Integer> numbers = graph.get(num);
        boolean flag = true;

        for (int i = 0; i < numbers.size(); i++) {
            if (visited[numbers.get(i)] == false) {
                dfs(numbers.get(i), depth + 1);
                flag = false;
            }
        }

        // 리프노드일 때만 더하기
        if (flag) {
            sumOfDepth += depth;
        }

    }

}
