import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] words = new String[n];

        int result = 0;

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();

            Stack<Character> stack = new Stack<>();
            char[] wordToChar = word.toCharArray();

            int index = 0;
            stack.push(wordToChar[index]);

            while (true) {
                index++;

                if (index >= wordToChar.length) {
                    break;
                }

                if (stack.isEmpty()) {
                    stack.push(wordToChar[index]);
                    continue;
                }

                char top = stack.peek();
                if (top == wordToChar[index]) {
                    stack.pop();
                    continue;
                }

                stack.push(wordToChar[index]);
            }

            if (stack.isEmpty()) {
                result++;
            }
        }

        System.out.println(result);
    }
}
