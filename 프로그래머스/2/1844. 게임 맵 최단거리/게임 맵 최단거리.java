import java.util.*;

class Solution {
    
    int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] records = new int[n][m];
        boolean[][] visited = new boolean[n][m];
    
        records[0][0] = 1;
        visited[0][0] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            
            int x = top[0];
            int y = top[1];
            
            for(int[] direction : DIRECTIONS){
                int dx = direction[0] + x;
                int dy = direction[1] + y;
                
                if(inRange(dx, dy, n, m) && maps[dx][dy] == 1 && !visited[dx][dy]){
                    visited[dx][dy] = true;
                    records[dx][dy] = records[x][y]+1;
                    q.offer(new int[]{dx,dy});
                }
            }
        }
        
        if(!visited[n-1][m-1]){
            return -1;
        }
        
        return records[n-1][m-1];
    }
    
    private boolean inRange(int x, int y, int n, int m){
        return x<n && x>=0 && y < m && y>=0;
    }
}