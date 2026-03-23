import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static boolean[][] map;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]); // 정점의 번호

        map = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            map[a][b] = true;
            map[b][a] = true;
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }

    private static void dfs(int a){
        System.out.print(a+" ");
        visited[a] = true;

        for(int i=1; i<visited.length; i++){
            if(visited[i] == false && (map[a][i] || map[i][a])){
                visited[i] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int a){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[map[0].length];

        q.offer(a);
        visited[a] = true;

        while(!q.isEmpty()){
            int top = q.poll();
            System.out.print(top+" ");

            for(int i=1; i<visited.length; i++){
                if(i != top && visited[i] == false && (map[top][i] || map[i][top])){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}