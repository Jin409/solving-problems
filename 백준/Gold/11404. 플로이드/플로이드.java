import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] costs = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        
        for(int i=0; i<m; i++){
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]) - 1;
            int end = Integer.parseInt(input[1]) - 1;
            int cost = Integer.parseInt(input[2]);

            if(costs[start][end]!= Integer.MAX_VALUE){
                costs[start][end] = Math.min(costs[start][end], cost);
                continue;
            }
            costs[start][end] = cost;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j){
                        continue;
                    }
                    
                    if(costs[i][k] != Integer.MAX_VALUE && costs[k][j] != Integer.MAX_VALUE){
                        costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                    }
                }
            }
        }

        // ===== 정답 출력부 =====
         for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(costs[i][j] == Integer.MAX_VALUE){
                    costs[i][j] = 0;
                }
                System.out.print(costs[i][j]+" ");
            }
             System.out.println();
         }
    }
}