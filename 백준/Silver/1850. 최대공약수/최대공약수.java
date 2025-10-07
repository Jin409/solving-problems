import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static long gcd;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);

        GCD(Math.min(a,b), Math.max(a,b));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String block = "1".repeat(10_000);
        for (long i = 0; i < gcd / 10_000; i++){
            bw.write(block);
        }
        bw.write("1".repeat((int)(gcd % 10_000)));
        bw.flush();
    }

    private static void GCD(long a, long b){
        if(b%a==0){
            gcd = a;
            return;
        }
        
        GCD(b%a, a);
    }
}