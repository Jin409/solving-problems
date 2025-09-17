import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static long totalBudget;
    private static long[] budgets;
    private static int n;
    private static long answer;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        budgets = new long[n];
        long max = 0;
        long total = 0;
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            budgets[i] = Long.parseLong(s[i]);
            max = Math.max(max, budgets[i]);
            total += budgets[i];
        }
        totalBudget = Long.parseLong(br.readLine());

        if(total <= totalBudget){
            System.out.println(max);
            return;
        }
        solve(1, max);
        
        System.out.println(answer);
    }

    private static void solve(long left, long right){
        if(left > right){
            return;
        }
        
        long middle = (left+right)/2;

        long tempTotal = 0;
        for(long budget : budgets){
            tempTotal += Math.min(budget, middle);
        }

        if(tempTotal > totalBudget){
            solve(left, middle-1);
            return;
        }
        if(tempTotal < totalBudget){
            answer = Math.max(answer, middle);
            solve(middle+1, right);
            return;
        }
        if(tempTotal == totalBudget){
            answer = Math.max(answer, middle);
            return;
        }
    }
}