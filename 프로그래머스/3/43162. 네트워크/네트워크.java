import java.util.*;

class Solution {
    // union-find
    
    int[] parents;
    
    private int findParent(int x){
        if(parents[x] == x){
            return x;
        }
        
        // 계속해서 업데이트
        return parents[x] = findParent(parents[x]);
    }
    
    private void union(int o1, int o2){
        int parentO1 = findParent(o1);
        int parentO2 = findParent(o2);
        
        parents[parentO2] = parentO1; // 합치기
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i; // 초기화
        }
        
        for(int i=0; i<n; i++){
            int[] computer = computers[i];
            
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }
                
                if(computer[j] == 1){
                    union(i, j);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(findParent(i));
        }
        
        return set.size();
    }
}