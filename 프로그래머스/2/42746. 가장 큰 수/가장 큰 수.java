import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Queue<String> q = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(String o1, String o2){
                return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
            }
        });
        
        for(int number : numbers){
            q.offer(String.valueOf(number));
        }
        
        StringBuilder sb = new StringBuilder();

        if(q.peek().equals("0")){
            return "0";
        }
        
        while(!q.isEmpty()){
            sb.append(q.poll());
        }
        
        return sb.toString();
    }
}