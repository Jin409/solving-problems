class Solution {
    
    long answer = Long.MAX_VALUE;
    
    public long solution(int n, int[] times) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<times.length; i++){
            min = Math.min(min, times[i]);
        }
        
        long start = 0;
        long end = (long) n * (long) min;
        
        solve(start, end, times, n);
        
        return answer;
    }
    
    private void solve(long start, long end, int[] times, int n){
        if(start > end){
            return;
        }
        
        long middle = (start+end)/2;
        
        // System.out.println("=====");
        // System.out.println("middle: "+middle);
        
        long ans = 0; // 해당 시간동안 몇명이 가능한가
        for(int i=0; i<times.length; i++){
            ans += (long) middle/ (long) times[i];
        }
        
        // System.out.println("ans: "+ans);
        
        if(ans >= n){ // 더 많은 사람을 처리 가능 -> 더 시간을 줄여보기
            answer = Math.min(middle, answer);
            solve(start, middle-1, times, n);
        }else{
            solve(middle+1, end, times, n);
        }
    }
}