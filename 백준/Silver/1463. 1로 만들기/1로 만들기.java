import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n + 1];

        for (int i = 0; i < n; i++) {
            map[i] = Integer.MAX_VALUE;
        }

        for (int i = n; i >= 0; i--) {
            if (i % 3 == 0) {
                map[i / 3] = Math.min(map[i / 3], map[i] + 1);
            }

            if (i % 2 == 0) {
                map[i / 2] = Math.min(map[i / 2], map[i] + 1);
            }

            if (i - 1 >= 0) {
                map[i - 1] = Math.min(map[i - 1], map[i] + 1);
            }
        }

        System.out.print(map[1]);
    }
}
