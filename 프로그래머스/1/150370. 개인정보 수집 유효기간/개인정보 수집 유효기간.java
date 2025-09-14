import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> termsToMap = new HashMap<>();
        for(String term : terms){
            String[] s = term.split(" ");
            termsToMap.put(s[0], Integer.parseInt(s[1]));
        }
        
        for(int i=0; i<privacies.length; i++){
            String privacy = privacies[i];
            
            String[] s = privacy.split(" ");
            String registeredDate = s[0];
            String term = s[1];
            
            if(isExpired(today, registeredDate, termsToMap.get(term))){
                answer.add(i+1);
            }
        }
        
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
    
    private int calculateExpiredDay(int registeredDay){
        int result = (registeredDay-1+28)%28;
        if(result==0){
            return 28;
        }
        return result;
    }
    
    private boolean isExpired(String today, String registeredDate, int expirationMonth){
        int yearOfToday = parseYear(today);
        int monthOfToday = parseMonth(today);
        int dayOfToday = parseDay(today);
        
        int yearOfRegisteredDate = parseYear(registeredDate);
        int monthOfRegisteredDate = parseMonth(registeredDate);
        int dayOfRegisteredDate = parseDay(registeredDate);
        
        int expiredYear = yearOfRegisteredDate;
        if(monthOfRegisteredDate+expirationMonth > 12){
            expiredYear = yearOfRegisteredDate+(monthOfRegisteredDate+expirationMonth)/12;
        }
        
        int expiredMonth = monthOfRegisteredDate+expirationMonth;
        if(monthOfRegisteredDate+expirationMonth > 12){
            expiredMonth = (monthOfRegisteredDate+expirationMonth)%12;
            if(expiredMonth==0){
                expiredMonth = 12;
                expiredYear--;
            }
        }
        
        int expiredDay = calculateExpiredDay(dayOfRegisteredDate);

        if(expiredDay > dayOfRegisteredDate){
            int originExpiredMonth = expiredMonth;
            
            expiredMonth--;
            if(expiredMonth==0){
                expiredMonth = 12;
            }
            
            if(expiredMonth > originExpiredMonth){
                expiredYear--;
            }
        }
        
        System.out.println("오늘: "+today);
        System.out.println("등록한 날: "+registeredDate);
        
        System.out.println("만료되는 해: "+expiredYear);
        System.out.println("만료되는 달: "+expiredMonth);
        System.out.println("만료되는 날: "+expiredDay);
        
        System.out.println("유효기간: "+expirationMonth);
        
        System.out.println("=======");
        
        if(expiredYear < yearOfToday){
            return true;
        }
        
        if(expiredYear == yearOfToday && expiredMonth < monthOfToday){
            return true;
        }
        
        if(expiredYear == yearOfToday && expiredMonth == monthOfToday && expiredDay < dayOfToday){
            return true;
        }
        
        return false;
    }
    
    private int parseYear(String raw){
        return Integer.parseInt(raw.split("\\.")[0]);
    }
    
    private int parseMonth(String raw){
        return Integer.parseInt(raw.split("\\.")[1]);
    }
    
    private int parseDay(String raw){
        return Integer.parseInt(raw.split("\\.")[2]);
    }
}