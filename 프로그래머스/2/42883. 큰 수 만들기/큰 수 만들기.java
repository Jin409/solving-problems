import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        
        String[] s = number.split("");
        int n = s.length;
        
        int[] digits = new int[n];
        for(int i=0; i<n; i++){
            digits[i] = Integer.parseInt(s[i]);
        }
        
        int count = 0;
        Deque<Integer> d = new ArrayDeque<>();
        for(int num : digits){
            
            if(d.isEmpty()){
                d.push(num);
                continue;
            }
            
            if(d.peek() > num){
                d.push(num);
                continue;
            }
            
            while(!d.isEmpty() && d.peek() < num && count < k){
                d.poll();
                count++;
            }
            
            d.push(num);
        }
        
        while(count < k){
            count++;
            d.poll();
        }
        
        String answer = "";
        while(!d.isEmpty()){
            answer += String.valueOf(d.pollLast());
        }
        
        return answer;
    }
}