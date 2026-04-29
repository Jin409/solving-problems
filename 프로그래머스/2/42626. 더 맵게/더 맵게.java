import java.util.*;

class Solution {
    
    private boolean canEnd(PriorityQueue<Integer> pq, int K){
        return pq.peek() >= K;
    }
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 가장 낮은 것 + 두번째로 낮은 것 더해서 다시 push
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        while(!canEnd(pq, K)){
            
            if(pq.size() < 2){
                answer = -1;
                break;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first + second * 2);
            
            answer++;
        }
        
        return answer;
    }
}