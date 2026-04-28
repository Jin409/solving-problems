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
        int right = people.length - 1;
        
        while(left < right){
            
            if(newP.get(left) + newP.get(right) <= limit){
                answer++;
                left++;
                right--;
                continue;
            }
            
            right--;
        }

        // 5 5 7 8
        System.out.println(answer);
        answer += (people.length - answer * 2);
        return answer;
    }
}