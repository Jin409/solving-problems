package 팰린드롬_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    private static final String FAILURE_SENTENCE = "I'm Sorry Hansoo";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        char[] alphabets = new char[26];

        for (char c : input.toCharArray()) {
            alphabets[c - 'A']++;
        }

        if (!isPalindrome(alphabets)) {
            System.out.println(FAILURE_SENTENCE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        String answer = "";

        for (int i = 0; i < alphabets.length; i++) {
            for (int j = 0; j < alphabets[i] / 2; j++) {
                sb.append((char) (i + 65));

            }
        }

        answer += sb.toString();
        String end = sb.reverse().toString();

        sb = new StringBuilder();
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] % 2 != 0) {
                sb.append((char) (i + 65));
            }
        }
        answer += sb.toString();

        System.out.println(answer + end);
    }

    private static final boolean isPalindrome(char[] alphabets) {
        int countOfOddNumber = 0;

        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] % 2 != 0) {
                countOfOddNumber++;
            }
        }
        return countOfOddNumber < 2;
    }
}
