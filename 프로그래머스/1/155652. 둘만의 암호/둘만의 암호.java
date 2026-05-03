import java.util.*;

class Solution {
    private char findAlphabet(char c, String skip, int index){
        char result = c;
        
        for(int i=0; i<index; i++){
            result++;
            
            if(Integer.valueOf(result) == Integer.valueOf('z' + 1)){
                result = 'a';
            }
            
            while(true){
                if(!skip.contains(String.valueOf(result))){
                    break;
                }
                
                result++;
                
                if(Integer.valueOf(result) == Integer.valueOf('z' + 1)){
                    result = 'a';
                }
            }
        }
        
        return result;
    }
    
    public String solution(String s, String skip, int index) {
        StringBuffer sb = new StringBuffer();
        
        for(char c : s.toCharArray()){
            sb.append(findAlphabet(c, skip, index));
        }
        
        return sb.toString();
    }
}