import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // 테스트 케이스의 개수

        for (int i = 0; i < t; i++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]); // 문서의 개수
            int target = Integer.parseInt(input[1]); // 알아내고자 하는 문서의 번호 (0부터 시작)

            int[] numbers = parseNumbers(scanner, n);

            int count = 0;

            Queue<Integer> queue = new LinkedList<>();

            // index 를 큐에 넣어서 비교하기
            for (int j = 0; j < n; j++) {
                queue.add(j);
            }

            while (!queue.isEmpty()) {
                int top = queue.poll();
                int topValue = numbers[top];
                int maxNumber = findMaxNumber(numbers);

                if (topValue < maxNumber) {
                    queue.add(top);
                    continue;
                }

                count++;
                numbers[top] = 0;
                if (top == target) {
                    System.out.println(count);
                    break;
                }
            }
        }

    }

    private static int findMaxNumber(int[] numbers) {
        int maxNumber = 0;

        for (int number : numbers) {
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        return maxNumber;
    }

    private static int[] parseNumbers(Scanner scanner, int n) {
        String[] rawNumbers = scanner.nextLine().split(" ");
        int[] numbers = new int[n];
        for (int j = 0; j < n; j++) {
            numbers[j] = Integer.parseInt(rawNumbers[j]);
        }
        return numbers;
    }
}
