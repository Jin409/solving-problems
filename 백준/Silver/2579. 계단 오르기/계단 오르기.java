import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] map = new int[n + 1];
        map[1] = scores[1];
        if (n >= 2) {
            map[2] = map[2 - 1] + scores[2];
        }
        if (n >= 3) {
            map[3] = Math.max(map[3 - 2], scores[3 - 1]) + scores[3];
        }

        if (n >= 4) {
            for (int i = 4; i <= n; i++) {
                map[i] = Math.max(map[i - 2], map[i - 3] + scores[i - 1]) + scores[i];
            }
        }

        System.out.print(map[n]);
    }
}
