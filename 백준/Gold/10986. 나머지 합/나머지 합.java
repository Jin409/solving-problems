import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long result = 0;                
        long[] cnt = new long[M];       

        st = new StringTokenizer(br.readLine()); 
        long prefix = 0;
        for (int i = 0; i < N; i++) {
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            prefix += x;
            int r = (int)(((prefix % M) + M) % M); 
            if (r == 0) result++;                
            cnt[r]++;                              
        }

        for (int r = 0; r < M; r++) {
            long c = cnt[r];
            if (c >= 2) result += c * (c - 1) / 2;
        }

        System.out.println(result);
    }
}