import java.util.*;

class Solution {
    
    Map<Integer, Integer> mapToChange = new HashMap<>();
    Map<Integer, Integer> mapOfLines = new HashMap<>();
    
    {
        mapOfLines.put(1, 1);
        mapOfLines.put(2, 1);
        mapOfLines.put(3, 1);
        mapOfLines.put(4, 2);
        mapOfLines.put(5, 2);
        mapOfLines.put(6, 2);
        mapOfLines.put(7, 3);
        mapOfLines.put(8, 3);
        mapOfLines.put(9, 3);
        mapOfLines.put(0, 4);
        mapOfLines.put(-1, 4);
        mapOfLines.put(-2, 4);
    }
    
    {
        mapToChange.put(-1, 10);
        mapToChange.put(0, 11);
        mapToChange.put(-2, 12);
    }

    public String solution(int[] numbers, String hand) {
        int left = -1; // 시작 지점
        int right = -2; // 시작 지점
        
        StringBuilder sb = new StringBuilder();
        
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                left = number;
                sb.append("L");
                continue;
            }
            
            if(number == 3 || number == 6 || number == 9){
                right = number;
                sb.append("R");
                continue;
            }
            
            int dLeft = calculateDistance(left, number);
            int dRight = calculateDistance(right, number);
            
            if(dLeft > dRight || (dLeft == dRight && hand.equals("right"))){
                right = number;
                sb.append("R");
            }
            
            if(dLeft < dRight || (dLeft == dRight && hand.equals("left"))){
                left = number;
                sb.append("L");
            }
        }
        
        return sb.toString();
    }
    
    private int calculateDistance(int origin, int arriveAt){
        int originLine = mapOfLines.get(origin);
        int arriveLine = mapOfLines.get(arriveAt);
        int lineDiffernece = Math.abs(originLine-arriveLine);
        
        if(mapToChange.containsKey(origin)){
            origin = mapToChange.get(origin);
        }
        
         if(mapToChange.containsKey(arriveAt)){
            arriveAt = mapToChange.get(arriveAt);
        }
        
        int distance = lineDiffernece;
        
        if(originLine == arriveLine){
            distance += Math.abs(arriveAt - origin);
        }
        
        if(originLine > arriveLine){
            origin = origin - (3 * lineDiffernece);
            distance += Math.abs(arriveAt - origin);
        }
        
        if(originLine < arriveLine){
            origin = origin + (3 * lineDiffernece);
            distance += Math.abs(arriveAt - origin);
        }
        
        return distance;
    }
}