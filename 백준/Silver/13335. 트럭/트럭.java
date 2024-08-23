

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 트럭의 수
        int w = Integer.parseInt(input[1]); // 다리의 길이
        int l = Integer.parseInt(input[2]); // 다리의 최대 하중

        input = br.readLine().split(" ");
        Queue<Integer> weights = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            weights.add(Integer.parseInt(input[i]));
        }

        int ans = 0;
        int onBridgeWeight = 0; // 다리 위에 있는 무게의 합

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0); // 빈 다리를 만든다
        }

        while (!bridge.isEmpty()) {
            ans++;
            onBridgeWeight -= bridge.poll();

            if (!weights.isEmpty()) {
                int weight = weights.peek();
                if (weight + onBridgeWeight <= l) {
                    onBridgeWeight += weight;
                    bridge.add(weight);
                    weights.poll();
                } else {
                    bridge.add(0);
                }
            }

        }

        System.out.println(ans);
    }

}
