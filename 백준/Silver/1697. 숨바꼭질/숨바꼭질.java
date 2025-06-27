import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 수빈의 위치
        int k = Integer.parseInt(s[1]); // 동생의 위치

        int start = Math.min(n, k); // 시작 지점
        int end = Math.max(n, k); // 끝 지점

        int[] map = new int[100_000 + 1];
        Arrays.fill(map, Integer.MAX_VALUE);

        // 수빈이가 전진할 때
        if (n == start) {
            moveForward(start, map);
        } else {
            moveBackward(start, map);
        }

        System.out.println(map[end]);
    }

    private static void moveBackward(int start, int[] map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        map[start] = 0;

        while (!queue.isEmpty()) {
            Integer top = queue.poll();

            if (top - 1 >= 0 && map[top - 1] == Integer.MAX_VALUE) {
                queue.add(top - 1);
                map[top - 1] = Math.min(map[top - 1], map[top] + 1);
            }

            if (top + 1 <= map.length - 1 && map[top + 1] == Integer.MAX_VALUE) {
                queue.add(top + 1);
                map[top + 1] = Math.min(map[top + 1], map[top] + 1);
            }

            if (top / 2 > 0 && map[top / 2] == Integer.MAX_VALUE) {
                queue.add(top / 2);
                map[top / 2] = Math.min(map[top / 2], map[top] + 1);
            }

        }
    }

    private static void moveForward(int start, int[] map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        map[start] = 0;

        while (!queue.isEmpty()) {
            Integer top = queue.poll();

            if (top - 1 >= 0 && map[top - 1] == Integer.MAX_VALUE) {
                queue.add(top - 1);
                map[top - 1] = Math.min(map[top - 1], map[top] + 1);
            }

            if (top + 1 <= map.length - 1 && map[top + 1] == Integer.MAX_VALUE) {
                queue.add(top + 1);
                map[top + 1] = Math.min(map[top + 1], map[top] + 1);
            }

            if (top * 2 <= map.length - 1 && map[top * 2] == Integer.MAX_VALUE) {
                queue.add(top * 2);
                map[top * 2] = Math.min(map[top * 2], map[top] + 1);
            }

        }
    }
}
