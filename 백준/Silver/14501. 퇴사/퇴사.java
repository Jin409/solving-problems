import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static int[] time;
    private static int[] pay;

    private static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        time = new int[n];
        pay = new int[n];
        
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");

            time[i] = Integer.parseInt(s[0]);
            pay[i] = Integer.parseInt(s[1]);
        }

        int[] dp = new int[n+1];

        for(int i=n-1; i>=0; i--){
            int t = time[i];
            int p = pay[i];

            dp[i] = dp[i+1];

            if(t+i <= n){
                dp[i] = Math.max(dp[i+t] + p, dp[i]);
            }
        }

        System.out.print(dp[0]);
    }
}