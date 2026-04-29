import java.util.*;

class Solution {
    
    Set<Integer> answers = new HashSet<>();
    
    private boolean isPrime(int number){
        if(number == 1 || number == 0){
            return false;
        }
        
        for(int i=2; i<number; i++){
            if(number%i==0){
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(String numbers) {
        String[] values = numbers.split("");
        
        int n = values.length;
        int[] digits = new int[n];
        
        for(int i=0; i<n; i++){
            digits[i] = Integer.parseInt(values[i]);
        }
        
        find(digits, "", new boolean[n]);
        
        return answers.size();
    }
    
    private void find(int[] digits, String value, boolean[] visited){
        
        if(value.length() > 0){
            int number = Integer.parseInt(value);
            if(isPrime(number)){
                answers.add(number);
            }
        }
        
        for(int i=0; i<digits.length; i++){
            
            if(!visited[i]){
                visited[i] = true;
                find(digits, value+String.valueOf(digits[i]), visited);
                visited[i] = false;
            }
            
        }
        
    }
}