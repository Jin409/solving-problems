import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split("");

        int index = 0;

        while (index < strings.length) {
            if (strings.length - index < 10) {
                StringBuilder s = new StringBuilder();
                for (int i = index; i < strings.length; i++) {
                    s.append(strings[i]);
                    index++;
                }
                System.out.println(s);
                continue;
            }

            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                s.append(strings[index]);
                index++;
            }
            System.out.println(s);
        }
    }
}
