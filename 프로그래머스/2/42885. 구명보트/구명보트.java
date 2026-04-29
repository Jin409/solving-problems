import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        List<Integer> newP = new ArrayList<>();
        for(int p : people){
            newP.add(p);
        }
        Collections.sort(newP);
        
        int left = 0;
        int right = newP.size() - 1;
        
        while(left < right){
            
            if(newP.get(left) + newP.get(right) <= limit){
                left++;
                right--;
                answer++;
            }else{
                right--;
            }
        }
        
        answer += (newP.size() - answer * 2);
        return answer;
    }
}