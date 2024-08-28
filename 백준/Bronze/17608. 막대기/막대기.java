

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            s.push(Integer.parseInt(br.readLine()));
        }

        int count = 1;
        int currentHeight = s.pop();

        while (!s.isEmpty()) {
            int height = s.pop();
            if (currentHeight < height) {
                currentHeight = height;
                count++;
            }
        }

        System.out.println(count);
    }

}
