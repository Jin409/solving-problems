class Solution {
    
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int x, int[][] computers){
        
        for(int i=0; i<computers.length; i++){
            if(i==x){
                continue;
            }
            
            if(!visited[i] && computers[x][i] == 1){
                visited[i] = true;
                dfs(i, computers);
            }
        }
        
    }
}