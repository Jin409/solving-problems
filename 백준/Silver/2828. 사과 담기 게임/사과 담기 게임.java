import java.util.Scanner;

public class Main {

    static int moveCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int n = Integer.parseInt(input[0]); // 스크린이 n 칸으로 나눠져있다.
        int m = Integer.parseInt(input[1]); // 스크린의 아랫쪽에 m 칸
        int j = Integer.parseInt(scanner.nextLine()); // 떨어지는 사과의 개수

        int[] apples = new int[j + 1];

        for (int i = 1; i <= j; i++) {
            apples[i] = Integer.parseInt(scanner.nextLine());
        }

        getStartPoint(j, apples, m);

        System.out.println(moveCount);
    }

    private static int getStartPoint(int j, int[] apples, int m) {
        int startPoint = 1;

        for (int i = 1; i <= j; i++) {
            int point = apples[i];

            while (true) {
                int endPoint = startPoint + m - 1;

                if (endPoint >= point && startPoint <= point) {
                    break;
                }

                if (endPoint < point) {
                    startPoint++;
                    moveCount++;
                    continue;
                }

                if (startPoint > point) {
                    startPoint--;
                    moveCount++;
                }
            }
        }
        return startPoint;
    }

}
