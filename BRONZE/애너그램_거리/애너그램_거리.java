package BRONZE.애너그램_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    private static final int NUMBER_OF_ALPHABETS = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= numberOfTestCase; i++) {
            String firstWord = br.readLine();
            String secondWord = br.readLine();

            char[] alphabetsOfFirstWord = new char[NUMBER_OF_ALPHABETS];
            char[] alphabetsOfSecondWord = new char[NUMBER_OF_ALPHABETS];

            for (char c : firstWord.toCharArray()) {
                alphabetsOfFirstWord[c - 'a']++;
            }

            for (char c : secondWord.toCharArray()) {
                alphabetsOfSecondWord[c - 'a']++;
            }

            System.out.println(
                    "Case #" + i + ": " + calculateDistance(alphabetsOfFirstWord, alphabetsOfSecondWord));
        }
    }

    private static int calculateDistance(final char[] alphabetsOfFirstWord, final char[] alphabetsOfSecondWord) {
        int distance = 0;

        for (int i = 0; i < NUMBER_OF_ALPHABETS; i++) {
            if (alphabetsOfFirstWord[i] < alphabetsOfSecondWord[i]) {
                distance += alphabetsOfSecondWord[i] - alphabetsOfFirstWord[i];
            } else if (alphabetsOfFirstWord[i] > alphabetsOfSecondWord[i]) {
                distance += alphabetsOfFirstWord[i] - alphabetsOfSecondWord[i];
            }
        }

        return distance;
    }
}
