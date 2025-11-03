import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // n/2 마리를 선택 & 최대한 많은 종류
        
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        for(int num : nums){
            int value = map.getOrDefault(num, 0);
            value++;
            map.put(num, value);
            
            if(!keys.contains(num)){
                keys.add(num);
            }
        }
        
        Set<Integer> answer = new HashSet<>();
        int index = 0;
        int count = 0;
        
        while(count < (n/2)){
            if(index >= keys.size()){
                index = 0;
            }

            while(true){
                if(index >= keys.size()){
                    index = 0;
                }
                
                int key = keys.get(index);
                int value = map.get(key);
                if(value > 0){
                    value--;
                    map.put(key, value);
                    answer.add(key);
                    count++;
                    break;
                }
                index++;
            }
            
            index++;
        }
        
        return answer.size();
    }
}