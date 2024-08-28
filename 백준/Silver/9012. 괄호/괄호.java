

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            boolean ans = true;
            Stack<Character> s = new Stack<>();

            for (char c : input.toCharArray()) {
                if (c == '(') {
                    s.push(c);
                } else {
                    if (s.isEmpty()) {
                        ans = false;
                        break;
                    }
                    s.pop();
                }
            }

            if (!s.isEmpty()) {
                ans = false;
            }

            if (ans) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
