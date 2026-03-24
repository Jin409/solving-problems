import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            List<int[]> locations = new ArrayList<>();
            List<List<Integer>> map = new ArrayList<>();

            for(int i=0; i<n+2; i++){
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                locations.add(new int[]{x,y});

                map.add(new ArrayList<>());
            }

            for(int i=0; i<n+2; i++){
                for(int j=i+1; j<n+2; j++){
                    if(manhatton(locations.get(i), locations.get(j)) <= 1_000){
                        map.get(i).add(j);
                        map.get(j).add(i);
                    }
                }
            }

            if(bfs(locations, map)){
                System.out.println("happy");
                continue;
            }
            System.out.println("sad");
        }
    }

    private static int manhatton(int[] location1, int[] location2){
        return Math.abs(location1[0]-location2[0]) + Math.abs(location1[1]-location2[1]);
    }

    private static boolean bfs(List<int[]> locations, List<List<Integer>> map){

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visited = new boolean[locations.size()];
        visited[0] = true;

        while(!q.isEmpty()){
            int top = q.poll();

            if(top == locations.size() - 1){
                return true;
            }

            for(int connection : map.get(top)){
                if(visited[connection]){
                    continue;
                }

                visited[connection] = true;
                q.offer(connection);
            }
        }

        return false;
    }
}