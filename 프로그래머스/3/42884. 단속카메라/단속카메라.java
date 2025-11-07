import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Queue<Integer> q = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return routes[o1][1] - routes[o2][1];
            }
        });
        
        for(int i=0; i<routes.length; i++){
            q.offer(i);
        }
        
        int top = q.poll();
        int before = routes[top][1]; // 가장 빨리 나간 지점
        answer++;
        
        while(!q.isEmpty()){
            top = q.poll();
            
            int in = routes[top][0];
            int out = routes[top][1];
            
            if(before < in){
                before = out;
                answer++;
            }
        }
        
        return answer;
    }
}