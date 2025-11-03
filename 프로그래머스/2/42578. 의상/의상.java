import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){            
            int value = map.getOrDefault(cloth[1], 0);
            value++;
            
            map.put(cloth[1], value); 
        }
        
        int[] answers = new int[map.keySet().size()];
        
        int index = 0;
        
        for(String key : map.keySet()){
            int value = map.get(key);
            if(index == 0){
                answers[index] = value;
                index++;
            }else{
                answers[index] = answers[index-1] * value + value + answers[index-1];
                index++;
            }
        }
        
        return answers[index-1];
    }
}