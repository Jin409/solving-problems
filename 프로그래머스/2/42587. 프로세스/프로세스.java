import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int n = priorities.length;
        
        Queue<Integer> q = new LinkedList<>();
        
        // 우선순위에 따라
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return priorities[o2] - priorities[o1];
            }
        });
        
        for(int i=0; i<n; i++){
            q.offer(i);
            pq.offer(i);
        }
        
        int count = 1;
        
        while(!q.isEmpty()){
            int top = q.poll();
            int topP = pq.peek(); // 가장 높은 우선순위
            
            // if(!q.contains(topP)){
            //     pq.poll();
            // }

            topP = pq.peek();
            
            // 가장 우선순위가 높은 프로세스
            if(priorities[top] == priorities[topP]){
                if(top == location){
                    answer = count;
                }
                pq.poll();
                count++;
            }else{
                q.offer(top); // 다시 넣기
            }
        }
        
        return answer;
    }
}