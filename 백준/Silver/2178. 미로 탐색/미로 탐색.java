import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static int[][] map;
    private static int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1},
    };
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];

        for(int i=0; i<n; i++){
            input = br.readLine().split("");
            for(int j=0; j<m; j++){
                int a = Integer.parseInt(input[j]);
                map[i][j] = a;
            }
        }

        bfs(0, 0);

        System.out.print(map[n-1][m-1]);
    }

    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x < n && y < m;
    }

    private static void bfs(int a, int b){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a,b});

        while(!q.isEmpty()){
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];

            int originCount = map[x][y];

            for(int[] DIRECTION : DIRECTIONS){
                int dx = x + DIRECTION[0];
                int dy = y + DIRECTION[1];

                if(!inRange(dx, dy)){
                    continue;
                }

                if(map[dx][dy] == 1){
                    map[dx][dy] = originCount + 1;
                    q.offer(new int[]{dx,dy});
                }
            }
        
        }
    }
}
