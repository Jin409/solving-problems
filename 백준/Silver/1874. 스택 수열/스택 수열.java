import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        int number = 1;
        int index = 0;
        boolean isAvailable = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(number);
        result.add("+");

        while (index < n) {
            if (stack.isEmpty()) {
                number++;
                stack.push(number);
                result.add("+");
                continue;
            }

            int top = stack.peek();
            if (top == numbers[index]) {
                // top 이 해당 숫자인 경우
                stack.pop();
                result.add("-");
                index++;
                continue;
            }
            if (number > numbers[index]) {
                System.out.println("NO");
                isAvailable = false;
                return;
            }
            number++;
            stack.push(number);
            result.add("+");
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
