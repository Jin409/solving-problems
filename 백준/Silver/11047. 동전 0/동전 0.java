import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] coins = new int[n];

        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i=n-1; i>=0; i--){
            if(coins[i] > k){
                continue;
            }

            count += k / coins[i];
            k %= coins[i];
        }

        System.out.print(count);
    }
}