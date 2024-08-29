import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Deque<int[]> d = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            d.add(new int[]{i + 1, Integer.parseInt(input[i])});
        }

        while (true) {
            int[] top = d.pollFirst();

            int index = top[0];
            int num = top[1];

            System.out.println(index);

            if (d.isEmpty()) {
                break;
            }

            // 양수인 경우
            if (num > 0) {
                for (int i = 0; i < num - 1; i++) {
                    d.add(d.pollFirst());
                }
            } else {
                for (int i = 0; i < -num; i++) {
                    d.addFirst(d.pollLast());
                }
            }
        }
    }
}
