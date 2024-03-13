package BRONZE.팰린드롬인지_확인하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String originWord = br.readLine();
        char[] chars = originWord.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }

        if (String.valueOf(chars).equals(originWord)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
