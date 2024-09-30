

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] values = new int[n];
        int[] result = new int[k + 1];

        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                int value = values[j];
                if (i < value) {
                    continue;
                }
                if (result[i] == 0) {
                    result[i] = result[i - value] + 1;
                    continue;
                }
                result[i] = Math.min(result[i - value] + 1, result[i]);

            }
        }

        System.out.println(result[k]);
    }
}