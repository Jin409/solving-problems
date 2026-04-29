import java.util.*;

class Solution {
    
    PriorityQueue<List<String>> answers;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        answers = new PriorityQueue<>(new Comparator<List<String>>(){
            @Override
            public int compare(List<String> o1, List<String> o2){

                for(int i=0; i<o1.size(); i++){
                    if(o1.get(i).equals(o2.get(i))){
                        continue;
                    }
                    
                    // 서로 다른 글자인 경우
                    for(int j=0; j<3; j++){
                        if(o1.get(i).charAt(j) != o2.get(i).charAt(j)){
                            return o1.get(i).charAt(j) - o2.get(i).charAt(j);
                        }
                    }
                }
                
                return 0;
            }
        });
        
        List<String> routes = new ArrayList<>();
        routes.add("ICN");
        dfs(tickets, "ICN", routes, new boolean[tickets.length]);
        
        return answers.poll().toArray(new String[0]);
    }
    
    private boolean canEnd(boolean[] visited){
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    
    private void dfs(String[][] tickets, String now, List<String> routes, boolean[] visited){
        
        if(canEnd(visited)){
            answers.add(new ArrayList<>(routes));
            return;
        }
     
        for(int i=0; i<tickets.length; i++){
            
            if(visited[i]){
                continue;
            }
            
            if(tickets[i][0].equals(now)){
                
                routes.add(tickets[i][1]);
                visited[i] = true;
                dfs(tickets, tickets[i][1], routes, visited);
                routes.remove(routes.size() - 1);
                visited[i] = false;
            }
            
        }
        
    }
}