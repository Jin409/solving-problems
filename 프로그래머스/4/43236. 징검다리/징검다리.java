import java.util.*;

class Solution {
    
    int[] newRocks;
    int answer;
    
    public int solution(int distance, int[] rocks, int n) {
        newRocks = new int[rocks.length+1];
        for(int i=0; i<rocks.length; i++){
            newRocks[i] = rocks[i];
        }
        newRocks[rocks.length] = distance;
        
        Arrays.sort(newRocks);
        
        solve(0, distance, n);

        return answer;
    }
    
    private int countRemovals(int distance){
        int count = 0;
        int current = 0;
        
        for(int rock : newRocks){
            if(rock - current < distance){
                count++; // 제거해야 하는 돌
            }else{
                // 남기기
                current = rock;
            }
        }
        
        return count;
    }
    
    private void solve(int start, int end, int n){
        if(start > end){
            return;
        }
        
        int middle = (start+end)/2;
        int count = countRemovals(middle);
        
        // 제거해야 하는 돌의 개수가 더 많은 경우 -> 줄이기
        if(count > n){
            solve(start, middle-1, n);
        }else{
            answer = Math.max(answer, middle);
            solve(middle+1, end, n);
        }
    }
}