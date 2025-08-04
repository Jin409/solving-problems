import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int maxCount = Integer.parseInt(s[0]);
        int length = Integer.parseInt(s[1]);

        Set<String> set = new LinkedHashSet<>();
        String[] input = new String[length];

        for (int i = 0; i < length; i++) {
            String studentNumber = br.readLine();
            input[i] = studentNumber;
        }

        for (int i = length - 1; i >= 0; i--) {
            set.add(input[i]);
        }

        List<String> answer = new ArrayList<>(set);

        StringBuilder sb = new StringBuilder();
        int size = answer.size();
        for (int i = 0; i < Math.min(maxCount, answer.size()); i++) {
            sb.append(answer.get(size - 1 - i) + "\n");
        }
        System.out.println(sb);
    }
}
