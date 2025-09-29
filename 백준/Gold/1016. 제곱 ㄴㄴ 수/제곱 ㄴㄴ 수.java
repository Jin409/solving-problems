import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long min = Long.parseLong(s[0]);
        long max = Long.parseLong(s[1]);

        int n = (int)(max - min + 1);   
        boolean[] hit = new boolean[n]; 

        long limit = (long)Math.sqrt(max);
        for (long i = 2; i <= limit; i++) {
            long sq = i * i;
            long start = ((min + sq - 1) / sq) * sq; 
            for (long v = start; v <= max; v += sq) {
                hit[(int)(v - min)] = true;
            }
        }

        int ans = 0;
        for (int idx = 0; idx < n; idx++) {
            if (!hit[idx]) ans++;
        }
        System.out.println(ans);
    }
}