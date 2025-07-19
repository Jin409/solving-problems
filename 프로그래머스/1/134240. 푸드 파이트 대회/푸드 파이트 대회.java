import java.util.*;

class Solution {
    public String solution(int[] foods) {
        // 팰린드롬
        
        int size = 1; // 물
        for(int i=1; i<foods.length; i++){
            if(foods[i]%2==0){
                size+=foods[i];
            }else{
                size = size + (foods[i]-1);
            }
        }
        
        int[] newFoods = new int[size];
        int start = 0;
        int end = size-1;
        
        for(int i=1; i<foods.length; i++){
            for(int j=0; j<foods[i]/2; j++){
                newFoods[start] = i;
                newFoods[end] = i;
                
                start++;
                end--;
            }
        }
        
        String answer = "";
        for(int i=0; i<newFoods.length; i++){
            if(i == (newFoods.length/2)){
                answer+="0";
                continue;
            }
            answer += String.valueOf(newFoods[i]);
        }
        
        return answer;
    }
}