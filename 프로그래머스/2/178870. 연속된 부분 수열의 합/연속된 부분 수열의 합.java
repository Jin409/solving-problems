class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        
        for(int end = 0; end < sequence.length; end++){
            currentSum += sequence[end];
            
            while(currentSum > k){
                currentSum -= sequence[start];
                start++;
            }
            
            int currentLength = end - start;
            
            if(currentSum == k){
                if(currentLength < minLength){
                    minLength = currentLength;
                    answer = new int[]{start, end};
                }else if(currentLength == minLength && start < answer[0]){
                    answer = new int[]{start, end};
                }
            }
        }

        return answer;
    }
}