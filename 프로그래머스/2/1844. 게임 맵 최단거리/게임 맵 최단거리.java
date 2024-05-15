import java.util.*;

class Solution {
    private List<List<Integer>> directions = List.of(
        List.of(0, 1), // 동
        List.of(0,-1), // 서
        List.of(-1, 0), // 북
        List.of(1, 0) // 남
    );
    int[][] maps;
    int[][] distances;
    int n; // 가로
    int m; // 세로
    
    public int solution(int[][] maps) {
        this.maps = maps;
        this.n = maps.length;
        this.m = maps[0].length;
        distances = new int[n][m];
        
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(List.of(0,0));
        distances[0][0] = 1;
        
        while(!q.isEmpty()){
            List<Integer> v = q.poll();
            int x = v.get(0);
            int y = v.get(1);
            
            for(List<Integer> direction : directions){
                int newX = x+direction.get(0);
                int newY = y+direction.get(1);
                
                if(isValid(newX, newY) && maps[newX][newY]==1){
                    if(distances[newX][newY]==0){
                        distances[newX][newY] = distances[x][y]+1;
                        q.add(List.of(newX, newY));
                    }else{
                       distances[newX][newY] = Math.min(distances[x][y]+1, distances[newX][newY]);
                    }
                }
                
            }
        }
        if(distances[n-1][m-1]==0){
            return -1;
        }else{
            return distances[n-1][m-1];
        }
    }
    
    public boolean isValid(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
}