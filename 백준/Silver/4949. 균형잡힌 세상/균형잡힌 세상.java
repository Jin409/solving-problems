
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            boolean ans = true;

            if (input.equals(".")) {
                break;
            }

            StringBuffer sb = new StringBuffer();
            for (char c : input.toCharArray()) {
                if (c == '[' || c == ']' || c == '(' || c == ')') {
                    sb.append(c);
                }
            }
            String t = sb.toString();

            Stack<Character> s = new Stack<>();
            for (char c : t.toCharArray()) {
                if (ans == false) {
                    break;
                }

                if (c == '[' || c == '(') {
                    s.add(c);
                } else {
                    if (c == ']') {
                        if (!s.isEmpty() && s.peek() == '[') {
                            s.pop();
                        } else {
                            ans = false;
                            break;
                        }
                    } else if (c == ')') {
                        if (!s.isEmpty() && s.peek() == '(') {
                            s.pop();
                        } else {
                            ans = false;
                            break;
                        }
                    }
                }
            }
            if (!s.isEmpty()) {
                ans = false;
            }

            if (ans) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }

}
