import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<String> st = new Stack<>();
        
        String[] input = s.split("");
        
        for(int i=0; i<input.length; i++){
            
            String in = input[i];
            
            if(st.isEmpty()){
                st.push(in);
                continue;
            }
            
            if(st.peek().equals(in)){
                st.pop();
            }else{
                st.push(in);
            }
        }
        
        if(st.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }

        return answer;
    }
}