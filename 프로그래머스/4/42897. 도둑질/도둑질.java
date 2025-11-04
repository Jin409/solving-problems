class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int n = money.length;
        int[] answers1 = new int[n];
        int[] answers2 = new int[n];
        
        // 첫번째 집은 터는 경우 -> 마지막 집은 절대 못 털음
        answers1[0] = money[0];
        answers1[1] = Math.max(money[0], money[1]);
        
        for(int i=2; i<n-1; i++){
            answers1[i] = Math.max(answers1[i-2] + money[i], answers1[i-1]);
        }
        
        // 첫번째 집은 털지 않는 경우 -> 마지막 집은 무조건 털음
        answers2[0] = 0;
        answers2[1] = money[1];
        
        for(int i=2; i<n; i++){
            answers2[i] = Math.max(answers2[i-2] + money[i], answers2[i-1]);
        }
    
        return Math.max(answers1[n-2], answers2[n-1]);
    }
}