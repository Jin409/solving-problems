class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int[][] answers = new int[n][n];
        answers[0][0] = triangle[0][0];
        
        // 삼각형의 변은 결과가 정해짐
        for(int i=1; i<n; i++){
            answers[i][0] = answers[i-1][0] + triangle[i][0];
            answers[i][i] = answers[i-1][i-1] + triangle[i][i];
        }
        
        for(int i=2; i<n; i++){
            for(int j=1; j<i; j++){
                answers[i][j] = Math.max(answers[i-1][j-1], answers[i-1][j]) + triangle[i][j];
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++){
            answer = Math.max(answers[n-1][i], answer);
        }
        
        return answer;
    }
}