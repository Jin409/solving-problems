import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int n = Integer.parseInt(input[0]); // 원의 크기
        int m = Integer.parseInt(input[1]); // 마지노선
        int l = Integer.parseInt(input[2]); // 간격

        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(0);
        }

        System.out.println(solve(m, people, 1, n, l) - 1);
    }

    private static int solve(int limit, List<Integer> people, int startPoint, int circleSize, int gap) {
        int result = 0;
        int now = startPoint;

        while (true) {
            if (people.contains(limit)) {
                break;
            }
            result++;

            Integer recieveCount = people.get(now);
            people.set(now, recieveCount + 1);

            if (people.get(now) >= limit) {
                break;
            }

            if (recieveCount % 2 == 0) {
                now = moveReserveClockWise(circleSize, gap, now);
                continue;
            }

            now = moveClockWise(circleSize, gap, now);
        }

        return result;
    }

    private static int moveClockWise(int circleSize, int gap, int now) {
        return (now + gap) % circleSize;
    }

    private static int moveReserveClockWise(int circleSize, int gap, int now) {
        return (now - gap + circleSize) % circleSize;
    }

}
