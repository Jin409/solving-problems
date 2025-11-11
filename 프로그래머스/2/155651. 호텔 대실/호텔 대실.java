import java.util.*;

class Solution {
    
    private int calculateTime(String in, String out){
        String[] splitIn = in.split(":");
        String[] splitOut = out.split(":");
        
        int inHour = Integer.parseInt(splitIn[0]);
        int inMinute = Integer.parseInt(splitIn[1]);
        
        int outHour = Integer.parseInt(splitOut[0]);
        int outMinute = Integer.parseInt(splitOut[1]);
        
        if(outMinute >= inMinute){
            return (outMinute - inMinute) + (outHour - inHour) * 60;
        }
        
        return ((outMinute+60) - inMinute) + (outHour - inHour - 1) * 60;
    }
    
    private int getFasterInTime(String firstIn, String secondIn){
        String[] splitFirstIn = firstIn.split(":");
        String[] splitSecondIn = secondIn.split(":");
        
        int firstInHour = Integer.parseInt(splitFirstIn[0]);
        int firstInMinute = Integer.parseInt(splitFirstIn[1]);
        
        int secondInHour = Integer.parseInt(splitSecondIn[0]);
        int secondInMinute = Integer.parseInt(splitSecondIn[1]);
        
        if(firstInHour != secondInHour){
            return firstInHour - secondInHour;
        }
        
        return firstInMinute - secondInMinute;
    }
    
    private boolean isAvailable(String firstOut, String secondIn){
        String[] splitFirstOut = firstOut.split(":");
        String[] splitSecondIn = secondIn.split(":");
        
        int firstOutHour = Integer.parseInt(splitFirstOut[0]);
        int firstOutMinute = Integer.parseInt(splitFirstOut[1]);
        
        int secondInHour = Integer.parseInt(splitSecondIn[0]);
        int secondInMinute = Integer.parseInt(splitSecondIn[1]);
        
        firstOutMinute+=10;
        
        if(firstOutMinute >= 60){
            firstOutHour++;
            firstOutMinute -= 60;
        }
        
        if(firstOutHour < secondInHour){
            return true;
        }
        
        if(firstOutHour > secondInHour){
            return false;
        }
        
        if(firstOutMinute <= secondInMinute){
            return true;
        }
        
        return false;
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, new Comparator<>(){
            @Override
            public int compare(String[] a, String[] b){
                
                // 시작 시간이 다른 경우 -> 더 빠른 시간대로
                if(!a[0].equals(b[0])){
                    return getFasterInTime(a[0], b[0]);
                }
                
                int timeOfA = calculateTime(a[0], a[1]);
                int timeOfB = calculateTime(b[0], b[1]);
                
                return timeOfA - timeOfB;
            }
        });
        
        List<String[]> temp = new ArrayList<>();
        for(int i=0; i<book_time.length; i++){
            
            String[] now = book_time[i];
            
            boolean hasFound = false;
            for(int j=0; j<temp.size(); j++){
                String[] compared = temp.get(j);
                
                if(isAvailable(compared[1], now[0])){
                    hasFound = true;
                    temp.set(j, now);
                    break;
                }
            }
            
            if(!hasFound){
                answer++;
                temp.add(now);
            }
        }
        
        return answer;
    }
}