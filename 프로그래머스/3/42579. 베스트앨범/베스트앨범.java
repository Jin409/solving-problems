import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        Map<String, Integer> countsForG = new HashMap<>();
        for(int i=0; i<n; i++){
            String key = genres[i];
            
            int value = countsForG.getOrDefault(key, 0);
            countsForG.put(key, value+plays[i]);
        }
        
        Queue<Integer> q = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(!genres[o1].equals(genres[o2])){ // 장르가 다른 경우
                    return countsForG.get(genres[o2]) - countsForG.get(genres[o1]);
                }
                
                if(plays[o1]!=plays[o2]){
                    return plays[o2] - plays[o1];
                }
                
                return o1 - o2;
            }
        });
        
        for(int i=0; i<n; i++){
            q.offer(i);
        }
        
        List<Integer> answers = new ArrayList<>();
        Map<String, Integer> countsForApply = new HashMap<>();
    
        while(!q.isEmpty()){
            int top = q.poll();
            String genre = genres[top];
            
            // System.out.println(top);
            
            if(countsForApply.containsKey(genre) && countsForApply.get(genre) == 2){
                continue;
            }
            
            int value = countsForApply.getOrDefault(genre, 0);
            countsForApply.put(genre, value+1);
            
            answers.add(top);
        }
        
        return answers.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}