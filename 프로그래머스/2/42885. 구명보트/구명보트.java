import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int n = people.length;
        
        int left = 0;
        int right = n-1;
        int count = 0;
        
        while(left < right){
            if(people[left] + people[right] <= limit){
                count++;
                left++;
                right--;
                continue;
            }
            
            right--;
        }
        
        answer = n - (count*2) + count;
        
        return answer;
    }
}