import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 원래 수업을 들을 수 있는 사람들
        
        List<Integer> duplicated = new ArrayList<>();
        List<Integer> rTemp = new ArrayList<>();
        for(int r : reserve){
            rTemp.add(r);
        }
        
        for(int l : lost){
            if(rTemp.contains(l)){
                duplicated.add(l);
            }
        }
        
        answer += duplicated.size();
        
        Queue<Integer> lq = new PriorityQueue<>();
        for(int l : lost){
            if(duplicated.contains(l)){
                continue;
            }
            lq.offer(l);
        }
        
        Queue<Integer> rq = new PriorityQueue<>();
        for(int r : reserve){
            if(duplicated.contains(r)){
                continue;
            }
            rq.offer(r);
        }
        
        while(!lq.isEmpty()){
            
            if(rq.isEmpty()){
                break;
            }
            
            int rTop = rq.peek(); // 여분
            int lTop = lq.peek(); // 잃어버린
            
            if(Math.abs(lTop - rTop) == 1){
                rq.poll();
                lq.poll();
                answer++;
                continue;
            }
            
            if(lTop > rTop){
                rq.poll();
            }else{
                lq.poll();
            }
        }
        
        return answer;
    }
}