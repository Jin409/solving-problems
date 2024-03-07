import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {

    private static final int REPETITION = 10;
    private static final int DEVIDER = 42;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> answer = new HashSet<>();

        for (int i = 0; i < REPETITION; i++) {
            answer.add(Integer.parseInt(br.readLine()) % DEVIDER);
        }

        System.out.println(answer.size());
    }
}
