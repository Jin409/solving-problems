import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(char c : s.toCharArray()){
            // 알파벳이 아닌 경우는 그냥 더하기
            if(!Character.isAlphabetic(c)){
                answer += String.valueOf(c);
            }
            
            if(Character.isUpperCase(c)){
                int intValue = Integer.valueOf(c);
                int pushedValue = intValue + n;
                if(pushedValue>90){
                    answer += String.valueOf((char)('A'+(pushedValue-90-1)));
                }else{
                    answer += String.valueOf((char)(pushedValue));
                }
            }
            
            if(Character.isLowerCase(c)){
                int intValue = Integer.valueOf(c);
                int pushedValue = intValue + n;
                System.out.println(intValue);
                System.out.println(pushedValue);
                if(pushedValue>122){
                    answer += String.valueOf((char)('a'+(pushedValue-122-1)));
                }else{
                    answer += String.valueOf((char)(pushedValue));
                }
            }
        }
        
        return answer;
    }
}