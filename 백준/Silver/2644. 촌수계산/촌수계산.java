import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static List<List<Integer>> map = new ArrayList<>();
    private static int[] counts;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++){
            map.add(new ArrayList<>());
        }
        counts = new int[n+1];
        Arrays.fill(counts, -1);

        String[] input = br.readLine().split(" ");

        int targetA = Integer.parseInt(input[0]);
        int targetB = Integer.parseInt(input[1]);

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            map.get(a).add(b);
            map.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(targetA);

        counts[targetA] = 0;
        
        while(!q.isEmpty()){
            int top = q.poll();

            if(top == targetB){
                break;
            }

            List<Integer> connections = map.get(top);

            for(int connection : connections){
                if(counts[connection] == -1){
                    q.offer(connection);
                    counts[connection] = counts[top] + 1;
                }
            }
        }

        System.out.println(counts[targetB]);
    }
}