
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String origin = br.readLine();

        Stack<String> beforeCursor = new Stack<>();
        Stack<String> afterCursor = new Stack<>();

        for (char c : origin.toCharArray()) {
            beforeCursor.add(Character.toString(c));
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            String order = input[0];
            if (order.equals("P")) {
                String letter = input[1];
                beforeCursor.add(letter);
            }
            if (order.equals("L")) {
                if (beforeCursor.size() > 0) {
                    String s = beforeCursor.pop();
                    afterCursor.add(s);
                }
            }
            if (order.equals("D")) {
                if (afterCursor.size() > 0) {
                    String s = afterCursor.pop();
                    beforeCursor.add(s);
                }
            }
            if (order.equals("B")) {
                if (beforeCursor.size() > 0) {
                    beforeCursor.pop();
                }
            }
        }

        while (!beforeCursor.isEmpty()) {
            afterCursor.add(beforeCursor.pop());
        }

        while (!afterCursor.isEmpty()) {
            bw.append(afterCursor.pop());
        }

        bw.flush();
        bw.close();
    }
}
