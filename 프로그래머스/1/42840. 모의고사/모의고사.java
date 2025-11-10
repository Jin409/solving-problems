import java.util.*;

class Solution {
    public int[] solution(int[] answers) {   
        int[] first = new int[]{ 1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        int maxScore = 0;
        
        for(int i=0; i<answers.length; i++){
            int answer = answers[i];
            
            if(first[i%first.length] == answer){
                scores[0]++;
            }
            
            if(second[i%second.length] == answer){
                scores[1]++;
            }
            
            if(third[i%third.length] == answer){
                scores[2]++;
            }
            
            maxScore = Math.max(scores[0], maxScore);
            maxScore = Math.max(scores[1], maxScore);
            maxScore = Math.max(scores[2], maxScore);
        }
        
        List<Integer> results = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(scores[i] == maxScore){
                results.add(i+1);
            }
        }
        
        return results.stream().mapToInt(i->i).toArray();
    }
}