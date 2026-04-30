import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        
        for(int i : arr){
            if(s.isEmpty()){
                s.push(i);
            }else{
                if(i == s.peek()){
                    continue;
                }else{
                    s.push(i);
                }
            }
        }
        
        List<Integer> answer = new ArrayList<>(s);
        return answer.stream().mapToInt(i->i).toArray();
    }
}