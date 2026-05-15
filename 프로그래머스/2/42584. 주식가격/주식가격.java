class Solution {
    public int[] solution(int[] prices) {
        int[] answers = new int[prices.length];
        
        for(int i=0; i<prices.length - 1; i++){
            
            int answer = 0;
            
            for(int j=i; j<prices.length - 1; j++){
                if(prices[i] <= prices[j]){
                    answer++;
                    continue;
                }
                break;
            }
            
            if(answer == 0){
                answer++;
            }
            answers[i] = answer;
        }
        
        answers[prices.length - 1] = 0;
        return answers;
    }
}