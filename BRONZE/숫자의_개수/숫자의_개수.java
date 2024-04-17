package BRONZE.숫자의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result = a * b * c;

        int[] nums = new int[10];

        while (result >= 1) {
            nums[result % 10]++;
            result = result / 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(nums[i]);
        }
    }
}
