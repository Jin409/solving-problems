import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int[] answers = new int[jobs.length];
        
        // 작업 번호 넣어두기
        Queue<Integer> q = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(jobs[o1][1] != jobs[o2][1]){ // 소요 시간 오름차순
                    return jobs[o1][1] - jobs[o2][1];
                }
                
                if(jobs[o1][0] != jobs[o2][0]){ // 요청 시각 오름차순
                    return jobs[o1][0] - jobs[o2][0];
                }
                
                return o1 - o2; // 작업의 번호
            }
        });
        
        // 요청 시각 기준으로 오름차순
        Queue<Integer> requestTimeQ = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(jobs[o1][0] != jobs[o2][0]){ // 요청 시각 오름차순
                    return jobs[o1][0] - jobs[o2][0];
                }
                
                return o1 - o2; // 작업의 번호
            }
        });
        
        for(int i=0; i<jobs.length; i++){
            requestTimeQ.offer(i);
        }
        
        int time = 0;
        int index = 0;
        
        while(!requestTimeQ.isEmpty() || !q.isEmpty()){
            
            // System.out.println("=====");
            // System.out.println("time : "+time);
                    
            while(!requestTimeQ.isEmpty() && jobs[requestTimeQ.peek()][0] <= time){
                int top = requestTimeQ.poll();
                q.offer(top);
            }
            
            if (q.isEmpty() && !requestTimeQ.isEmpty()) {
                time = Math.max(time, jobs[requestTimeQ.peek()][0]); 
                
                while (!requestTimeQ.isEmpty() && jobs[requestTimeQ.peek()][0] <= time) {
                    q.offer(requestTimeQ.poll());
                }
            }
            
            int top = q.poll();
            // System.out.println("top: "+top);
            
            if(jobs[top][0] > time){
                time = jobs[top][0];
            }
            time += jobs[top][1];
            // System.out.println("time: "+time);
            
            answers[index] = time - jobs[top][0];
            // System.out.println("answers[index] : "+answers[index] );
            index++;
        }   
        
        int answer = 0;
        for(int ans : answers){
            answer+=ans;
        }
        
        return answer / answers.length;
    }
}