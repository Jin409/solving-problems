package BRONZE.팰린드롬수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();

            if (input.equals("0")) {
                break;
            }

            int start = 0;
            int end = input.length() - 1;
            char[] chars = input.toCharArray();

            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }

            if (String.valueOf(chars).equals(input)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
