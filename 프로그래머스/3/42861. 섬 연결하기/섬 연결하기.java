import java.util.*;

class Solution {
    
    int[] parent;
    
    // 부모 찾기
    private int find(int x){
        if(parent[x] == x){
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    private boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        
        if(parentX == parentY){
            return false; // 이미 같은 집합에 속하므로 추가할 필요 없음!
        }
        
        parent[parentX] = parent[parentY]; // 합침
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        Queue<int[]> q = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
        
        for(int [] cost : costs){
            q.offer(cost);
        }
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            
            if(union(top[0], top[1])){
                answer += top[2];
            }
        }
        
        return answer;
    }
}