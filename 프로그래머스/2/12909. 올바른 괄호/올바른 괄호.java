import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '('){
                st.add(c);
            }
            
            if(c == ')'){
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();
    }
}