import java.util.*;

class Solution {
    
    private static Map<String, Integer> friendsMap;
    private static int[][] giftsMap;
    private static int[] result;
    private static int[] giftCount; // 선물 지수
    
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        giftsMap = new int[n][n];
        result = new int[n]; // 각각이 받을 선물의 수 -> max 반환하면 됨
        giftCount = new int[n];
        
        friendsMap = new HashMap<>();
        for(int i=0; i<n; i++){
            String friend = friends[i];
            friendsMap.put(friend, i);
        }
        
        for(int i=0; i<gifts.length; i++){
            String[] s = gifts[i].split(" ");
            String giver = s[0];
            String reciever = s[1];
            
            int giverIndex = friendsMap.get(giver);
            int recieverIndex = friendsMap.get(reciever);
            
            giftsMap[giverIndex][recieverIndex]++;
        }
        
        // 선물 지수 계산하기
        for(int i=0; i<n; i++){
            int giveCount = 0;
            int recieveCount = 0;
            
            for(int j=0; j<n; j++){
                giveCount += giftsMap[i][j];
                recieveCount += giftsMap[j][i];
            }

            giftCount[i] = giveCount - recieveCount;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // 주고 받은 기록이 있고 && 수가 다른 경우 
                if((giftsMap[i][j] != 0 || giftsMap[j][i]!=0) && giftsMap[i][j] != giftsMap[j][i]){
                    if(giftsMap[i][j] > giftsMap[j][i]){
                        result[i]++;
                    }else{
                        result[j]++;
                    }
                    continue;
                }
            
                 // 주고 받은 기록이 있고 && 수가 같은 경우 -> 선물 지수로 거래해야 함
                if((giftsMap[i][j] != 0 || giftsMap[j][i]!=0) && giftsMap[i][j] == giftsMap[j][i]){
                    if(giftCount[i] == giftCount[j]){
                        continue;
                    }
                    
                    if(giftCount[i] > giftCount[j]){
                        result[i]++;
                    }else{
                        result[j]++;
                    }
                    continue;
                }
                
                // 주고 받은 기록이 없는 경우
                if(giftsMap[i][j] == 0 && giftsMap[j][i]==0){
                    if(giftCount[i] == giftCount[j]){
                        continue;
                    }
                    
                    if(giftCount[i] > giftCount[j]){
                        result[i]++;
                    }else{
                        result[j]++;
                    }
                }
        }}
        
        // ans
        int answer = 0;
        for(int i=0; i<n; i++){
           answer = Math.max(answer, result[i]);
        }
        return answer/2;

}}