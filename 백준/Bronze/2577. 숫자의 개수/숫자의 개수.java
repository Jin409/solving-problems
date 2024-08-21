

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int[] numbers = new int[10];

        String s = String.valueOf(a * b * c);
        for (int i = 0; i < s.length(); i++) {
            numbers[Integer.parseInt(String.valueOf(s.charAt(i)))] += 1;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(numbers[i]);
        }

    }
}
