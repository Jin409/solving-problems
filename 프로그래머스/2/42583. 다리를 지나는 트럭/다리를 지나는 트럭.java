import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0, sum = 0, idx = 0;

        // 다리 길이만큼 0으로 채워 시작 (빈 칸)
        for (int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }

        while (idx < truck_weights.length) {
            time++;                 // 1초 경과
            sum -= bridge.poll();   // 맨 앞 칸 내려감(트럭이면 하중 감소)

            // 다음 트럭을 올릴 수 있으면 올리고, 아니면 빈칸(0) 유지
            if (sum + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }

        return time + bridge_length;
    }
}