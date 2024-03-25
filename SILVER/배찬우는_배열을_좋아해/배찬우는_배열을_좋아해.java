package 배찬우는_배열을_좋아해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String[] input = s.split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);

        int[][] nums = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            input = s.split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < q; i++) {
            s = br.readLine();
            input = s.split(" ");
            int order = Integer.parseInt(input[0]);
            int num1 = Integer.parseInt(input[1]);
            int num2 = Integer.parseInt(input[2]);

            if (order == 0) {
                nums[num1][num2] = Integer.parseInt(input[3]);
            }

            if (order == 1) {
                int[] temp = nums[num1];
                nums[num1] = nums[num2];
                nums[num2] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                sb.append(nums[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
