import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> times = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            times.offer(new int[]{start, end});
        }

        int endTime = 0;
        int answer = 0;

        while(!times.isEmpty()){
            int[] top = times.poll();

            int start = top[0];
            int end = top[1];

            if(start >= endTime){
                answer++;
                endTime = end;
            }
        }

        System.out.print(answer);
    }
}