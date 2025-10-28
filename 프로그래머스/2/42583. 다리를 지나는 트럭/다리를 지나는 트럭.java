import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++){ bridge.offer(0); }

        int time = 0;
        int sum = 0;        
        int idx = 0;        

        while (idx < truck_weights.length) {
            time++;
            sum -= bridge.poll(); 

            int w = truck_weights[idx];
            if (sum + w <= weight) { 
                bridge.offer(w);
                sum += w;
                idx++;
            } else {                
                bridge.offer(0);
            }
        }

        return time + bridge_length;
    }
}