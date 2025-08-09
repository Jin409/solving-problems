import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int n = schedules.length;
        for(int i=0; i<n; i++){
            boolean notLate = true;
            
            int schedule = schedules[i];
            int[] timelog = timelogs[i];
            
            int hour = schedule/100;
            int minute = schedule%100;
            
            int availableHour = hour;
            int availableMinute = minute+10;
            
            if(minute >= 50){
                availableHour = hour + 1;
                availableMinute = availableMinute % 10;
            }
            
            for(int j=0; j<7; j++){
                int day = ((startday - 1 + j) % 7) + 1;
                if (day == 6 || day == 7) continue;
                
                if(timelog[j]>(availableHour*100+availableMinute)){
                    notLate = false;
                }
            }
            
            if(notLate){
                answer++;
            }
        }
        
        return answer;
    }
}