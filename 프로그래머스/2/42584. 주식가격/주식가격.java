import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            while(!s.isEmpty() && prices[i] < prices[s.peek()]){
                int top = s.pop();
                answer[top] = i - top;
            }
            
            s.push(i);
        }
        
        while(!s.isEmpty()){
            int index = s.pop();
            answer[index] = answer.length - index - 1;
        }
    
        return answer;
    }
}