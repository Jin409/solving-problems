import java.util.*;

class Solution {
    
    private boolean meetCondition(PriorityQueue<Integer> pq, int k){
        int size = pq.size();
        
        for(int i=0; i<size; i++){
            if(pq.peek() < k){
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville){
            pq.offer(scov);
        }
        
        boolean isAvailable = false;
        
        while(true){        
            if(meetCondition(pq, K)){
                isAvailable = true;
                break;
            }
            
            if(pq.size() < 2){
                break;
            }

            answer++;
            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first + second*2);
        }
        
        if(isAvailable){
            return answer;
        }
        return -1;
    }
}