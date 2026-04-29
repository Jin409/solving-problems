import java.util.*;

class Solution {
    
    private int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    
    private int n;
    private int m;
    
    private boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;

        n = maps.length;
        m = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        maps[0][0] = 0;
        
        int[][] distances = new int[n][m];
        distances[0][0] = 1;
        distances[n-1][m-1] = -1;
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            
            int x = top[0];
            int y = top[1];
            int distance = distances[x][y];
            
            for(int[] DIRECTION : DIRECTIONS){
                
                int dx = x + DIRECTION[0];
                int dy = y + DIRECTION[1];
                
                if(!inRange(dx, dy)){
                    continue;
                }
                
                if(maps[dx][dy] == 1){
                    distances[dx][dy] = distance + 1;
                    maps[dx][dy] = 0;
                    q.offer(new int[]{dx, dy});
                }
            }
        }

        return distances[n-1][m-1];
    }
}