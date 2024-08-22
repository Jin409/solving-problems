import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거
        // 제거된 후에는 배열의 원소들의 순서 유지
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int num : arr){
            q.add(num);
        }

        List<Integer> ans = new ArrayList<>();
        int before = q.poll();
        
        ans.add(before);
        
        while(!q.isEmpty()){
            int num = q.poll();
            if(num!=before){
                ans.add(num);
            }
            before = num;
        }
        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}