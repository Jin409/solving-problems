import java.util.*;

class Solution {
    Map<Integer, int[]> map = new HashMap<>();
    
    {
        map.put(0, new int[]{-1, 0});
        map.put(1, new int[]{-1, 1});
        map.put(7, new int[]{-1, -1});
        map.put(6, new int[]{0, -1});
        map.put(2, new int[]{0, 1});
        map.put(5, new int[]{1, -1});
        map.put(4, new int[]{1, 0});
        map.put(3, new int[]{1, 1});
    }
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        Set<String> visitedNodes = new HashSet<>(); // 방문한 노드(점) 기록
        Set<String> visitedEdges = new HashSet<>(); // 방문한 선분(길) 기록
        
        int x = 0;
        int y = 0;
        
        visitedNodes.add(String.format("%d,%d", x, y));
        
        for(int a : arrows){
            int[] direction = map.get(a);
            
            for (int j = 0; j < 2; j++) { 
                int beforeX = x;
                int beforeY = y;
                
                x += direction[0];
                y += direction[1];

                String edgeID;
                
                if (beforeX < x || (beforeX == x && beforeY < y)) {
                    edgeID = String.format("%d,%d,%d,%d", beforeX, beforeY, x, y);
                } else {
                    edgeID = String.format("%d,%d,%d,%d", x, y, beforeX, beforeY);
                }
                
                // a) 도착 노드가 이미 방문했던 노드이고 (폐쇄 고리)
                // b) 방금 통과한 선분이 처음 지나가는 선분일 때 (새로운 영역 형성)
                String nodeID = String.format("%d,%d", x, y);

                if (visitedNodes.contains(nodeID) && !visitedEdges.contains(edgeID)) {
                    answer++;
                }
                
                visitedNodes.add(nodeID);
                visitedEdges.add(edgeID);
            }
        }
        
        return answer;
    }
}