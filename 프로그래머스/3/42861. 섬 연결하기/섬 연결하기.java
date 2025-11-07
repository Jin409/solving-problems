import java.util.*;

class Solution {
    
    int[] parents;
    
    private int findParent(int x){
        if(parents[x] == x){
            return x;
        }
        
        return parents[x] = findParent(parents[x]);
    }
    
    private void union(int a, int b){
        int parentA = findParent(a);
        int parentB = findParent(b);

        parents[parentB] = parentA;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
    
        Queue<Integer> q = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return costs[o1][2] - costs[o2][2];
            }
        });
        
        for(int i=0; i<costs.length; i++){
            q.offer(i);
        }
        
        while(!q.isEmpty()){
            int top = q.poll();
            
            int a = costs[top][0];
            int b = costs[top][1];
            int c = costs[top][2];
            
            if(findParent(a) != findParent(b)){
                union(a, b);
                answer += c;
            }
        }
        
        return answer;
    }
}