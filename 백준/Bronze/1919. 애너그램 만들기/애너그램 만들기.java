
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int ans = 0;

        int[] count1 = new int[100];
        int[] count2 = new int[100];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'A'] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            count2[s2.charAt(i) - 'A'] += 1;
        }

        for (int i = 0; i < count1.length; i++) {
            while (count1[i] != count2[i]) {
                if (count1[i] > count2[i]) {
                    count1[i]--;
                }
                if (count1[i] < count2[i]) {
                    count2[i]--;
                }
                ans++;
            }
        }

        System.out.println(ans);
    }
}
