import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());

        Set<String> set = new HashSet<>();
        for(String s : phone_book){
            StringBuilder sb = new StringBuilder();
            
            for(char c : s.toCharArray()){
                sb.append(Character.toString(c));
                
                if(set.contains(sb.toString())){
                    return false;
                }
            }
            
            set.add(s);
        }
        
        return true;
    }
}