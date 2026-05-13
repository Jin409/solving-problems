import java.util.*;

class Solution {
    
    private boolean meetsCondition(PriorityQueue<Integer> q, int K){
        return q.peek() >= K;
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 가장 낮은 두 개의 음식을 섞어서 새롭게 하기
        // 모든 음식의 지수가 K 이상이 될 때까지
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            q.offer(scoville[i]);
        }
        
        while(!meetsCondition(q, K)){
            answer++;
            
            if(q.size() < 2){
                return -1;
            }
            
            int first = q.poll();
            int second = q.poll();
            
            q.offer(first + second * 2);
        }
        
        return answer;
    }
}