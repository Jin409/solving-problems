import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Queue<Character> q = new LinkedList<>(); 
        
        for(int i=0; i<s.length(); i++){
            q.add(s.charAt(i));
        }
        
        Queue<Character> temp = new LinkedList<>();
        
        while(!q.isEmpty()){
            Character c = q.poll();
            if(c.equals('(')){
                temp.add(c);
            }
            else{
                if(temp.size()==0){
                    return false;
                }
                if(temp.peek().equals('(')){
                    temp.poll();
                }else{
                    return false;
                }
            }
        }
        
        if(temp.size()>0){
            return false;
        }
        return true;
    }
}