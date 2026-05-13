class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        solve(0, 0, numbers, target);
        return answer;
    }
    
    private void solve(int index, int result, int[] numbers, int target){
        if(index >= numbers.length){
            if(target == result){
                answer++;
            }
            return;
        }
        
        solve(index+1, result + (numbers[index]), numbers, target);
        solve(index+1, result - (numbers[index]), numbers, target);
    }
}