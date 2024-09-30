

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());
        int[] sugar = new int[n + 1];

        sugar[0] = 0;
        sugar[1] = 0;
        sugar[2] = 0;

        for (int i = 3; i <= n; i++) {

            if (i == 5 || i == 3) {
                sugar[i] = 1;
                continue;
            } else if (i == 4) {
                continue;
            }

            if (sugar[i - 3] > 0 && sugar[i - 5] > 0) {
                sugar[i] = Math.min(sugar[i - 3] + 1, sugar[i - 5] + 1);
            } else if (sugar[i - 3] > 0) {
                sugar[i] = sugar[i - 3] + 1;
            } else if (sugar[i - 5] > 0) {
                sugar[i] = sugar[i - 5] + 1;
            }
        }

        if (sugar[n] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sugar[n]);
        }

    }
}