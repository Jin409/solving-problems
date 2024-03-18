package 단어_뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = br.readLine().split("(?<=\\>)|(?=\\<)"); // <> 포함해서 문자열 자르기
        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            if (word.contains("<")) { // <> 를 포함하면 그대로 붙이기
                builder.append(word);
            } else {
                String[] tempWords = word.split(" ");
                for (int i = 0; i < tempWords.length; i++) {
                    StringBuilder flippedStringBuilder = new StringBuilder(tempWords[i]).reverse();
                    tempWords[i] = flippedStringBuilder.toString();
                }
                builder.append(String.join(" ", tempWords));
            }
        }
        System.out.println(builder);
    }

}
