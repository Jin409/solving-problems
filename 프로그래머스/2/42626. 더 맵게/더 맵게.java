import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++){
            heap.add(scoville[i]);
        }
        
        while(true){
            // 모든 노드가 K 보다 커야 한다
            if(validScoville(heap, K)){
                break;
            }
            // 그렇지 않은 경우에는 섞어야 한다.
            if(heap.size()<2){
                return -1;
            }
            int newScoville = heap.poll() + (heap.poll() * 2); // 두번 뽑아서 섞는다
            heap.add(newScoville);
            
            answer++;
        }
        return answer;
    }
    
    private boolean validScoville(PriorityQueue<Integer> heap, int K){
        for(int i=0; i<heap.size(); i++){
            if(heap.peek()<K){
                return false;
            }
        }
        return true;
    }
}