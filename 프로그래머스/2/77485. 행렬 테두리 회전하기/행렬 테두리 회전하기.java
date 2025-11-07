class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows][columns];
        
        int number = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = number;
                number++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            
            int ans = Integer.MAX_VALUE;
            
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            
            int temp = map[x1][y1];
            int mn = temp;

            // 1) 왼쪽열 위로 당기기
            for (int x = x1+1; x <= x2; x++) { 
                map[x-1][y1] = map[x][y1]; 
                mn = Math.min(mn, map[x-1][y1]); 
            }

            // 2) 하단행 왼쪽으로 밀기
            for (int y = y1+1; y <= y2; y++) { 
                map[x2][y-1] = map[x2][y]; mn = Math.min(mn, map[x2][y-1]); 
            }

            // 3) 오른쪽열 아래로 내리기
            for (int x = x2-1; x >= x1; x--) { 
                map[x+1][y2] = map[x][y2]; 
                mn = Math.min(mn, map[x+1][y2]); 
            }

            // 4) 상단행 오른쪽으로 밀기
            for (int y = y2-1; y >= y1; y--) { 
                map[x1][y+1] = map[x1][y];
                mn = Math.min(mn, map[x1][y+1]); 
            }

            // 5) 빈자리에 temp 복구
            map[x1][y1+1] = temp;  // <-- 시계 회전 마무리
            
            answer[i] = mn;
        }
        
        return answer;
    }
}