package BRONZE.애너그램_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    private static final int COUNT_OF_ALPHABET = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstWord = br.readLine();
        String secondWord = br.readLine();

        char[] charsOfFirstWord = new char[COUNT_OF_ALPHABET];
        char[] charsOfSecondWord = new char[COUNT_OF_ALPHABET];

        for (char c : firstWord.toCharArray()) {
            charsOfFirstWord[c - 'a']++;
        }

        for (char c : secondWord.toCharArray()) {
            charsOfSecondWord[c - 'a']++;
            System.out.println(c);
            System.out.println(c - 'a');
        }

        int ans = 0;

        for (int i = 0; i < COUNT_OF_ALPHABET; i++) {
            if (charsOfFirstWord[i] > charsOfSecondWord[i]) {
                ans += charsOfFirstWord[i] - charsOfSecondWord[i];
            } else {
                ans += charsOfSecondWord[i] - charsOfFirstWord[i];
            }
        }

        System.out.println(ans);
    }
}
