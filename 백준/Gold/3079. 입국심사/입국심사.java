import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static long[] originTimes;
    private static int peopleCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 몇대인지
        peopleCount = Integer.parseInt(s[1]);

        originTimes = new long[n];
        long minValue = (long) Math.pow(10, 9);
        for (int i = 0; i < n; i++) {
            originTimes[i] = Long.parseLong(br.readLine());
            if (originTimes[i] < minValue) {
                minValue = originTimes[i];
            }
        }

        long answer = getAnswer(minValue, n);
        System.out.println(answer);
    }

    private static long getAnswer(long maxTime, int n) {
        long left = 0;
        long right = maxTime * peopleCount;
        long answer = right;

        while (left < right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += mid / originTimes[i]; // 각 심사관이 해당 분 동안 완료할 수 있는 사람의 수
                if (sum >= peopleCount) {
                    break;
                }
            }

            if (sum >= peopleCount) {
                answer = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

}
