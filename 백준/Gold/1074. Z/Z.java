import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int[][] matrix;
    private static int size;
    private static int num = 0;
    private static int R;
    private static int C;
    private static boolean isFound = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);

        double pow = Math.pow(2, N);
        size = (int) pow * (int) pow;
        solve(0, 0, size);
    }

    private static void solve(int x, int y, int size) {
        if (x == C && y == R) {
            System.out.println(num);
            return;
        }

        if (size == 1) {
            num++;
            return;
        }

        int half = size / 2;
        int cntPerQuad = half * half;

        // R 과 C 가 1사분면에 있는 경우
        if (C < x + half && R < y + half) {
            solve(x, y, half);
        } else {
            num += cntPerQuad;
        }

        // 2사분면에 있는 경우
        if (C >= x + half && R < y + half) {
            solve(x + half, y, half);
        } else {
            num += cntPerQuad;
        }

        // 3사분면에 있는 경우
        if (R >= y + half && C < x + half) {
            solve(x, y + half, half);
        } else {
            num += cntPerQuad;
        }

        // 4사분면에 있는 경우
        if (R >= y + half && C >= x + half) {
            solve(x + half, y + half, half);
        } else {
            num += cntPerQuad;
        }

    }

}
