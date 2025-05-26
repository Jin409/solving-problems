import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int K;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        K = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        Long max = 0L;
        List<Long> lines = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            long line = Long.parseLong(br.readLine());
            lines.add(line);
            max = Math.max(max, line);
        }

        long left = 1L;
        long right = max;
        long result = 0;

        while (left <= right) {

            long mid = (left + right) / 2;

            if (fitsTheCondition(lines, N, mid)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean fitsTheCondition(List<Long> lines, int targetCount, long length) {
        int count = 0;

        for (Long line : lines) {
            count += (int) (line / length);
        }

        return count >= targetCount;
    }
}
