import java.util.*;

class Solution {
    int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    
    private int n;
    private int m;
    
    private boolean inRange(int x, int y){
        return x<n && y<m && x>=0 && y>=0;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        int[][] dp = new int[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dp[0][0] = 1;
        maps[0][0] = 0;
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            
            for(int[] DIRECTION : DIRECTIONS){
                int dx = x + DIRECTION[0];
                int dy = y + DIRECTION[1];
                
                if(!inRange(dx, dy)){
                    continue;
                }
                
                if(maps[dx][dy] == 1){
                    q.offer(new int[]{dx, dy});
                    dp[dx][dy] = dp[x][y] + 1;
                    maps[dx][dy] = 0;
                }
            }
        }
        
        if(dp[n-1][m-1] == 0){
            return -1;
        }
        
        return dp[n-1][m-1];
    }
}