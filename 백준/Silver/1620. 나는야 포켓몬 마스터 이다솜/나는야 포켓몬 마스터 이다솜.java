
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> searchByIndex = new HashMap<>();
        HashMap<String, Integer> searchByName = new HashMap<>();
        int index = 1;

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            searchByIndex.put(index, name);
            searchByName.put(name, index);
            index++;
        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();

            // 알파벳이 아닌 경우
            if (!Pattern.matches("^[A-Za-z]*$", question)) {
                System.out.println(searchByIndex.get(Integer.parseInt(question)));
            } else {
                System.out.println(searchByName.get(question));
            }
        }
    }

}
