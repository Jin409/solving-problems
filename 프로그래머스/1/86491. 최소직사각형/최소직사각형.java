class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int width = 0;
        int height = 0;
        
        for(int i=0; i<sizes.length; i++){
            width = Math.max(sizes[i][0], width);
            height = Math.max(sizes[i][1], height);
        }
        
        // 가로가 더 크다면
        if(width > height){
            height = 0;
            // 명함 돌려보기
            for(int i=0; i<sizes.length; i++){
                if(sizes[i][0] < sizes[i][1]){
                    height = Math.max(sizes[i][0], height);
                }else{
                    height = Math.max(sizes[i][1], height);
                }
            }
        } else{ // 세로가 더 크거나 서로 같다면
            width = 0;
            
            for(int i=0; i<sizes.length; i++){
                if(sizes[i][0] < sizes[i][1]){
                    width = Math.max(sizes[i][0], width);
                }else{
                    width = Math.max(sizes[i][1], width);
                }
            }
        }
        
        return height * width;
    }
}