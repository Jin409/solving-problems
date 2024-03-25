package 구간_합_구하기_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] numberInput = br.readLine().split(" ");
        int[] numbers = new int[numberInput.length];
        int[] sums = new int[numberInput.length];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberInput[i]);
            sum += numbers[i];
            sums[i] = sum;
        }

        for (int k = 0; k < m; k++) {
            String[] s = br.readLine().split(" ");
            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            int answer = 0;

            if (i <= 1) {
                answer = sums[j - 1];
            } else {
                answer = sums[j - 1] - sums[i - 2];
            }

            System.out.println(answer);
        }
    }
}
