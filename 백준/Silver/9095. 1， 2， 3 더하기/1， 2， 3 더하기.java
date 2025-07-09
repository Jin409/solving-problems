import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        int[] numbers = new int[12];
        numbers[1] = 1;
        numbers[2] = 2;
        numbers[3] = 4;

        for (int i = 4; i <= 11; i++) {
            numbers[i] = numbers[i - 3] + numbers[i - 2] + numbers[i - 1];
        }

        while (testCase > 0) {
            testCase--;
            int n = Integer.parseInt(br.readLine());
            System.out.println(numbers[n]);
        }
    }
}
