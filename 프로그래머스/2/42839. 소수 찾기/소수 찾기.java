import java.util.*;

class Solution {
    
    Set<Integer> newNumbers;
    
    public int solution(String numbers) {
        int answer = 0;
        
        newNumbers = new HashSet<>();
        findNumbers(numbers.toCharArray(), "", 0);
        
        int max = 0;
        
        for(int newNumber : newNumbers) {
            max = Math.max(newNumber, max);
        }
        
        // 가장 큰 숫자까지의 범위 내에서 합성 수 모두 찾기
        boolean[] composites = getComposites(max);
        
        for(int newNumber : newNumbers){
            if(composites[newNumber] == false){
                answer++;
                // System.out.println("소수: "+newNumber);
            }
        }
        
        return answer;
    }
    
    private void findNumbers(char[] origin, String tmp, int index) {        
        if(!tmp.isEmpty()){
            newNumbers.add(Integer.parseInt(tmp));
        }
        
        if(tmp.length() >= origin.length || index >= origin.length){
            return;
        }

        findNumbers(origin, tmp, index+1);
        
        for(int i=0; i<origin.length; i++){
            if(origin[i]=='u'){
                continue;
            }
            
            char c = origin[i];
            origin[i] = 'u';
            
            findNumbers(origin, tmp + Character.toString(c), index+1);
            
            origin[i] = c;
        }
    }
    
    private boolean[] getComposites (int number){
        boolean[] answer = new boolean[number+1];
        answer[0] = true;
        answer[1] = true;
        
        for(int i=2; i<=Math.sqrt(number); i++){
            int cnt = 2;
            int tmp = i+i;
            
            while(tmp <= number){
                answer[tmp] = true;
                cnt++;
                tmp = (i*cnt);
            }
        }
        
        return answer;
    }
}