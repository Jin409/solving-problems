class Solution {
    
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        find(target, 0, numbers, numbers[0]);
        find(target, 0, numbers, numbers[0] * -1);
        return answer;
    }
    
    private void find(int target, int index, int[] numbers, int now){
        
        if(index >= numbers.length - 1){ 
            if(now == target){
                answer++;
            }   
            return;
        }
    
        find(target, index+1, numbers, now+(numbers[index+1]));
        find(target, index+1, numbers, now+(numbers[index+1]*-1));
    }
}