
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] targets = new int[n]; // 수열

        for (int i = 0; i < n; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }

        List<Character> ans = new ArrayList<>(List.of('+'));
        boolean isPossible = true;
        Stack<Integer> s = new Stack<>();
        int currentNumber = 1; // 이미 넣은 수
        s.push(currentNumber);

        for (int target : targets) {

            if (s.isEmpty()) {
                if (currentNumber < target) {
                    for (int i = 0; i < target - currentNumber; i++) {
                        ans.add('+');
                        currentNumber++;
                        s.push(currentNumber);
                    }
                } else {
                    isPossible = false;
                    break;
                }
            }

            Integer top = s.peek();
            if (top == target) {
                ans.add('-');
                s.pop();
            } else if (top < target) {
                int sub = target - currentNumber;
                for (int i = 0; i < sub; i++) {
                    ans.add('+');
                    currentNumber++;
                    s.push(currentNumber);
                }
                s.pop();
                ans.add('-');
            } else {
                while (!s.isEmpty()) {
                    top = s.pop();
                    ans.add('-');

                    if (top == target) {
                        break;
                    }
                    if (s.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                }
            }

        }

        if (!isPossible) {
            System.out.println("NO");
        } else {
            ans.stream().forEach(System.out::println);
        }

    }

}
