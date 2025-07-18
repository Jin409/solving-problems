import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> temp = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                temp.add(numbers[i]+numbers[j]);
            }
        }
        
        Set<Integer> set = new HashSet<>(temp);
        
       int[] answer = set.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}