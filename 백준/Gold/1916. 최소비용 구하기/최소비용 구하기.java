import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<int[]>> buses = new ArrayList<>();
        for(int i=0; i<=n; i++){
            buses.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]); // 버스 비용

            buses.get(start).add(new int[]{end, cost});
        }

        String[] input = br.readLine().split(" ");
        int startPoint = Integer.parseInt(input[0]);
        int arrivalPoint = Integer.parseInt(input[1]);

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        q.offer(new int[]{startPoint, 0});
        
        int[] costs = new int[n+1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[startPoint] = 0;

        while(!q.isEmpty()){
            int[] top = q.poll();

            int x = top[0];
            int cost = top[1];

            if (cost > costs[x]) continue;

            for(int[] points : buses.get(x)){
                int newPoint = points[0];
                int newCost = points[1];

                if(costs[newPoint] > cost + newCost){
                    q.offer(new int[]{newPoint, cost + newCost});
                    costs[newPoint] = cost + newCost;
                }
            }
        }

        System.out.println(costs[arrivalPoint]);
    }
}