import java.util.*;

class Solution {
    
    Set<Integer> madeNumbers = new HashSet<>();
    
    private boolean isPrime(int number){
        if(number == 0 || number == 1){
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
        int answer = 0;
        
        String[] input = numbers.split("");
        int[] digits = new int[input.length];
        for(int i=0; i<input.length; i++){
            digits[i] = Integer.parseInt(input[i]);
        }
        
        boolean[] visited = new boolean[digits.length];
        combination(digits, "", visited);
        
        System.out.println(madeNumbers);
        
        for(int number : madeNumbers){
            if(isPrime(number)){
                System.out.println(number);
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isFinished(boolean[] visited){
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    
    private void combination(int[] numbers, String input, boolean[] visited){
        if(input.length() > 0 ){
            madeNumbers.add(Integer.parseInt(input));
        }
        
        for(int i=0; i<numbers.length; i++){
            
            if(!visited[i]){
                visited[i] = true;
                combination(numbers, input+String.valueOf(numbers[i]), visited);
                visited[i] = false;
            }
            
        }
    }
}