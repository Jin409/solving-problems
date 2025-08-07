import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int number = 1;
        int pointer = 0;

        while (true) {
            String s1 = String.valueOf(number);

            for (char c : s1.toCharArray()) {
                if (c == s.charAt(pointer)) {
                    pointer++;
                }

                if (pointer == s.length()) {
                    System.out.println(number);
                    return;
                }
            }

            number++;
        }
    }
}
