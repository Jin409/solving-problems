import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static int[][] powers;

    private static boolean[] teams;
    private static int answer = Integer.MAX_VALUE;

    private static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        powers = new int[n][n];
        teams = new boolean[n];

        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                powers[i][j] = Integer.parseInt(s[j]);
            }
        }

        pick(0, 0);

        System.out.println(answer);
    }

    private static int totalPower(){
        int startTotal = 0;
        int linkTotal = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }
                
                if(teams[i] && teams[j]){
                    startTotal += powers[i][j];
                }

                if(!teams[i] && !teams[j]){
                    linkTotal += powers[i][j];
                }
            }
        }

        return Math.abs(startTotal - linkTotal);
    }

    private static void pick(int idx, int count){
        if(count == n/2){
            int totalPower = totalPower();
            answer = Math.min(totalPower, answer);
            return;
        }

        if(idx == n){
            return;
        }

        teams[idx] = true;
        pick(idx+1, count+1);

        teams[idx] = false;
        pick(idx+1, count);
    }
}