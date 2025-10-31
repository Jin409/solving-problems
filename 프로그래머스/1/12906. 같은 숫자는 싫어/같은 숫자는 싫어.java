import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        for(int num : arr){
            q.offer(num);
        }
        
        List<Integer> answer = new ArrayList<>();
        int before = -1;
        
        while(!q.isEmpty()){
            int top = q.poll();
            if(before != top){
                answer.add(top);
            }
            before = top;
        }

        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}