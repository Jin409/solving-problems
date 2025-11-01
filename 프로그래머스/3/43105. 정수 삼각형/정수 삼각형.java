import java.util.*;

class Solution {
    
    int[][] answer;

    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        answer = new int[n][n];
        answer[0][0] = triangle[0][0];
        
        if(n>=2){
             for(int i=1; i<n; i++){
                answer[i][0] = answer[i-1][0] + triangle[i][0];
                answer[i][i] = answer[i-1][i-1] + triangle[i][i];
            }
        }

        if(n>=3){
            for(int i=2; i<n; i++){
                for(int j=1; j<i; j++){
                   answer[i][j] = Math.max(answer[i-1][j-1], answer[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(answer[n-1][i], max);
        }
        
        return max;
    }
}