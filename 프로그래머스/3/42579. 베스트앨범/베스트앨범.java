import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        Map<String, Integer> countsForG = new HashMap<>();
        for(int i=0; i<n; i++){
            int value = countsForG.getOrDefault(genres[i], 0);
            countsForG.put(genres[i], value + plays[i]);
        }
        
        Queue<Integer> q = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                // 장르가 다르면 많이 재생된 장르 순으로
                if(!genres[o1].equals(genres[o2])){
                    return countsForG.get(genres[o2]) - countsForG.get(genres[o1]);
                }
                
                // 장르가 같으면 재생 숫자로
                if(plays[o1] != plays[o2]){
                    return plays[o2] - plays[o1];
                }
                
                return o1 - o2;
            }
        });
        
        for(int i=0; i<n; i++){
            q.offer(i);
        }
        
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> countsForRegister = new HashMap<>();
        
        while(!q.isEmpty()){
            int top = q.poll();
            String genre = genres[top];
            
            if(countsForRegister.containsKey(genre) && countsForRegister.get(genre) == 2){
                continue;
            }
            
            int value = countsForRegister.getOrDefault(genre, 0);
            countsForRegister.put(genre, value+1);
            
            answer.add(top);
        }
        
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}