package BRONZE.애너그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTestCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestCase; i++) {
            String input = br.readLine();
            String[] words = input.split(" ");
            char[] charArrayOfFirstWord = words[0].toCharArray();
            Arrays.sort(charArrayOfFirstWord);

            char[] charArrayOfSecondWord = words[1].toCharArray();
            Arrays.sort(charArrayOfSecondWord);

            if (String.valueOf(charArrayOfFirstWord).equals(String.valueOf(charArrayOfSecondWord))) {
                System.out.println(words[0] + " & " + words[1] + " are anagrams.");
            } else {
                System.out.println(words[0] + " & " + words[1] + " are NOT anagrams.");
            }
        }
    }
}
