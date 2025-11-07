class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        int[][] answers = new int[n][m];
        for(int i=0; i<m; i++){
           answers[0][i] = land[0][i];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<m; k++){
                    if(j==k){
                        continue;
                    }
                    
                    answers[i][j] = Math.max(answers[i-1][k] + land[i][j], answers[i][j]);
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<m; i++){
            answer = Math.max(answers[n-1][i], answer);
        }
        
        return answer;
    }
}