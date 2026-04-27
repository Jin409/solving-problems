class Solution {
    
    int answer = 0;
    
    public int solution(int[] citations) {
        find(0, 10_000, citations);
        return answer;
    }
    
    private void find(int start, int end, int[] citations){
        int middle = (start + end) / 2;
        
        if(start > end){
            return;
        }
        
        int overCounts = 0;
        
        for(int citation : citations){
            if(citation >= middle){
                overCounts++;
            }
        }
        
        if(overCounts >= middle){
            answer = Math.max(answer, middle);
            find(middle+1, end, citations);
        }else if(overCounts < middle){
            find(start, middle-1, citations);
        }
    }
}