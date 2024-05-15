import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(List.of(0,-1));
        
        // bfs 로
        while(!q.isEmpty()){
            List<Integer> v = q.poll();
            int result = v.get(0);
            int index = v.get(1);
        
            if(index == (numbers.length-1)){
                if(result==target){
                    answer++;
                }
                continue; // 이미 다 돌았음
            }
            index++; // 다음 숫자로 계산해서 넣기
            int number = numbers[index];
            q.add(List.of(result+number, index));
            q.add(List.of(result+(number*-1), index));
        }
        
        return answer;
    }
}