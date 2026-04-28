class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {    
        solve(numbers, target, 0, 0);
        return answer;
    }
    
    private void solve(int[] numbers, int target, int result, int index){
        if(index == numbers.length){
            if(target == result){
                answer++;
            }
            return;
        }
        
        solve(numbers, target, result + (numbers[index]), index+1);
        solve(numbers, target, result - (numbers[index]), index+1);
    }
}