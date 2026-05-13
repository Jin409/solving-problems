import java.util.*;

class Solution {
    
    private int n;
    
    private int markAsComplete(int index, int[] progresses){
        int result = 0;
        
        for(int i=index; i<n; i++){
            if(progresses[i]<100){
                return result;
            }
            progresses[i] = -1;
            result++;
        }
        
        return result;
    }
    
    private void progress(int[] progresses, int[] speeds, int amount, int index){
        for(int i=index; i<n; i++){
            progresses[i] += (amount * speeds[i]);
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answers = new ArrayList<>();
        
        n = progresses.length;
        
        for(int i=0; i<n; i++){
            if(progresses[i] == -1){
                continue;
            }
            
            int difference = (100 - progresses[i])/speeds[i];
            if((100 - progresses[i])%speeds[i] != 0){
                difference++;
            }
            
            progress(progresses, speeds, difference, i);
            
            int counts = markAsComplete(i, progresses);
            answers.add(counts);
        }
        
        return answers.stream().mapToInt(i->i).toArray();
    }
}