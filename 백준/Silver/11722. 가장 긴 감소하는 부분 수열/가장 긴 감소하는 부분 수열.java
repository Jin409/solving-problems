import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] numbers;
    static int[] lengths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        lengths = new int[n];
        lengths[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            int newLength = findMax(i);
            lengths[i] = newLength == 0 ? 1 : newLength + 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(lengths[i], ans);
        }
        System.out.println(ans);
    }

    public static int findMax(int index) {
        // 이전 숫자 중 index 의 숫자보다 크고, 길이가 가장 큰 수
        int num = numbers[index];
        int ans = 0;
        for (int i = 0; i < index; i++) {
            if (numbers[i] > num && ans < lengths[i]) {
                ans = lengths[i];
            }
        }
        return ans;
    }
}
