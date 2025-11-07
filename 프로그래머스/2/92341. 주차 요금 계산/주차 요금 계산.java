import java.util.*;

class Solution {
    private int calculateDifference(String in, String out){
        String[] splitIn = in.split(":");
        String[] splitOut = out.split(":");
        
        int hourIn = Integer.parseInt(splitIn[0]);
        int minuteIn = Integer.parseInt(splitIn[1]);
        
        int hourOut = Integer.parseInt(splitOut[0]);
        int minuteOut = Integer.parseInt(splitOut[1]);
        
        if(hourIn == hourOut){
            return minuteOut - minuteIn;
        }
        
        if(minuteOut > minuteIn){
            return (hourOut - hourIn) * 60 + (minuteOut - minuteIn);
        }
        return (60 - minuteIn) + minuteOut + (hourOut - hourIn - 1) * 60;
    }
    
    public int[] solution(int[] fees, String[] records) {    
        Map<String, Integer> timeOfCars = new HashMap<>();
        
        Map<String, String> recordOfCars = new HashMap<>();
        for(String record : records){
            String[] s = record.split(" ");
            
            String time = s[0];
            String carNo = s[1];
            String status = s[2];
            
            if(status.equals("IN")){
                recordOfCars.put(carNo, time);
            }else{ // 출차한 경우
                String timeIn = recordOfCars.get(carNo);
                
                // 시간 격차 계산
                int value = timeOfCars.getOrDefault(carNo, 0);
                value += calculateDifference(timeIn, time);
                timeOfCars.put(carNo, value);
                
                // 삭제
                recordOfCars.remove(carNo);
            }
        }
        
        // 출차가 되지 않은 차들
        for(String carNo : recordOfCars.keySet()){
            String timeIn = recordOfCars.get(carNo);
                
            // 시간 격차 계산
            int value = timeOfCars.getOrDefault(carNo, 0);
            value += calculateDifference(timeIn, "23:59");
            timeOfCars.put(carNo, value);
        }
        
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int timeUnit = fees[2];
        int unitOfFee = fees[3];
        
        int[] answer = new int[timeOfCars.keySet().size()];
        List<String> carNumbers = new ArrayList<>();
        Map<String, Integer> answersMap = new HashMap<>();
        
        for(String carNo : timeOfCars.keySet()){
            carNumbers.add(carNo);
            
            int duration = timeOfCars.get(carNo);
            // System.out.println(carNo+": "+duration+"분");
            
            if(duration <= defaultTime){ // 기본 요금 부과
               answersMap.put(carNo, defaultFee);
                continue; 
            }
            
            if((duration - defaultTime)%timeUnit==0){
                answersMap.put(carNo, defaultFee + ((duration - defaultTime)/timeUnit) * unitOfFee);
            }else{
                answersMap.put(carNo, defaultFee + ((duration - defaultTime)/timeUnit + 1) * unitOfFee);
            }
        }
        
        Collections.sort(carNumbers);
        for(int i=0; i<carNumbers.size(); i++){
            answer[i] = answersMap.get(carNumbers.get(i));
        }
        
        return answer;
    }
}