import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        Stack<Integer>[] stacks = new Stack[n + 1];
        for (int i = 0; i < n; i++) {
            stacks[i] = new Stack<>();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int line = Integer.parseInt(input[0]);
            int prat = Integer.parseInt(input[1]);

            Stack<Integer> stack = stacks[line];

            while (!stack.isEmpty() && stack.peek() > prat) {
                stack.pop();
                result++;
            }

            if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < prat)) {
                stack.push(prat);
                result++;
            }
        }

        System.out.println(result);
    }

}
