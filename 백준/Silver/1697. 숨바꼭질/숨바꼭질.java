import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    // 방향은 -1, +1, *2

    private static final int END_POINT = 100_000;

    private static boolean inRange(int x){
        return x >= 0 && x <= END_POINT;
    }
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] map = new int[END_POINT + 1];
        Arrays.fill(map, Integer.MAX_VALUE);

        map[n] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while(!q.isEmpty()){
            int top = q.poll();

            int[] candidates = new int[]{top-1, top+1, top*2};

            for(int candidate : candidates){
                if(inRange(candidate) && map[candidate] == Integer.MAX_VALUE){
                    map[candidate] = map[top] + 1;
                    q.offer(candidate);
                }
            }
        }

        System.out.print(map[k]);
    }
}