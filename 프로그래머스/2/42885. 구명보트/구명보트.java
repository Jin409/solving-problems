import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int n = people.length;
        int left = 0;
        int right = n - 1;
        
        List<Integer> newP = new ArrayList<>();
        for(int p : people){
            newP.add(p);
        }
        Collections.sort(newP);
        
        while(left < right){
            
            if(newP.get(left) + newP.get(right) <= limit){
                left++;
                right--;
                answer++;
            }else{
                right--;
            }
            
        }
        
        answer += (n - answer * 2);
        return answer;
    }
}