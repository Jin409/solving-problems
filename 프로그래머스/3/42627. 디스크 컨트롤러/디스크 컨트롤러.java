import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Queue<Integer> waitingQ = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(jobs[o1][1] != jobs[o2][1]){
                    return jobs[o1][1] - jobs[o2][1];
                }
                
                if(jobs[o1][0] != jobs[o2][0]){
                    return jobs[o1][0] - jobs[o2][0];
                }
                
                return o1 - o2;
            }
        });
        
        Queue<Integer> q = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
               return jobs[o1][0] - jobs[o2][0]; // 들어오는 시점에 따라 정렬
            }
        });
        for(int i=0; i<jobs.length; i++){
            q.offer(i);
        }
        
        int time = 0;
        
        while (!q.isEmpty() || !waitingQ.isEmpty()) {
            while (!q.isEmpty() && jobs[q.peek()][0] <= time) {
                waitingQ.offer(q.poll());
            }
            
            if (waitingQ.isEmpty()) { 
                time = jobs[q.peek()][0]; 
                continue; 
            } // ⏩ 점프

            int i = waitingQ.poll();
            time += jobs[i][1];
            answer += time - jobs[i][0];
        }
        
        return answer / jobs.length;
    }
}