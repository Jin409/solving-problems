import java.util.*;

class Solution {
    
    int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    
    int n;
    int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        // 도착할 수 없는지 확인하기
        if(!ableToReach(maps)){
            return -1;
        }
        
        int[][] times = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                times[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        times[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            
            int x = top[0];
            int y = top[1];
            
            for(int[] direction : DIRECTIONS){
                int dx = direction[0] + x;
                int dy = direction[1] + y;
            
                if(inRange(dx, dy) && maps[dx][dy] == 1) {
                    maps[dx][dy] = -1;
                    times[dx][dy] = times[x][y]+1;
                    q.offer(new int[]{dx, dy});
                }
            }
        }
        
        if(times[n-1][m-1] == Integer.MAX_VALUE){
            return -1;
        }
        
        return times[n-1][m-1];
    }
    
    private boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
    
    private boolean ableToReach(int[][] maps){
        int x = n-1;
        int y = m-1;
        
        for(int[] direction : DIRECTIONS){
            int dx = direction[0] + x;
            int dy = direction[1] + y;
            
            if(inRange(dx, dy) && maps[dx][dy] == 1){
                return true;
            }
        }
        
        return false;
    }
}