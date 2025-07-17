import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);
        
        for(int i=0; i<s.length(); i++){
            char c = s.toCharArray()[i];
            
            int index = (int) c - 'a';
            
            // 한번도 등장하지 않은 경우
            if(alphabets[index]==-1){
                answer[i] = -1;
                alphabets[index] = i;
            }else{
                // 이미 등장한 경우
                answer[i] = i-alphabets[index];
                alphabets[index] = i;
            }
            
        }
        
        return answer;
    }
}