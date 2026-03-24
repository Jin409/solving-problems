import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static int[][][] map;

    private static final int[][] DIRECTIONS = {
        {-1, 0, 0},
        {1, 0, 0},
        {0, -1, 0},
        {0, 1, 0},
        {0, 0, -1},
        {0, 0, 1}
    };

    private static int h;
    private static int n;
    private static int m;
    private static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);

        map = new int[h][n][m];

        List<int[]> startPoints = new ArrayList<>();

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                input = br.readLine().split(" ");
                for(int k=0; k<m; k++){
                    int sign = Integer.parseInt(input[k]);
                    map[i][j][k] = sign;
                    
                    if(sign == 1){
                        startPoints.add(new int[]{i,j,k});
                    }
                }
            }
        }

        // -1 없는 것
        // 0 익지 않은 토마토
        // 1 익은 토마토

        bfs(startPoints);

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        if(answer == 0){
            System.out.println(answer);
            return;
        }
        System.out.println(answer - 1);
    }

    private static boolean inRange(int x, int y, int z){
        return x >= 0 && y >=0 && z >=0 && x < h && y < n && z < m;
    }

    private static void bfs(List<int[]> startPoints){

        Queue<int[]> q = new LinkedList<>();
        
        for(int[] startPoint : startPoints){
            q.offer(startPoint);
        }

        while(!q.isEmpty()){
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            int z = top[2];

            int count = map[x][y][z];
            
            for(int[] DIRECTION : DIRECTIONS){
                int dx = x + DIRECTION[0];
                int dy = y + DIRECTION[1];
                int dz = z + DIRECTION[2];
    
                if(!inRange(dx, dy, dz)){
                    continue;
                }

                // System.out.println(dx + " " + dy + " " + dz);
                // System.out.println(map[dx][dy][dz]);

                if(map[dx][dy][dz] == 0){
                    answer = Math.max(count + 1, answer);
                    map[dx][dy][dz] = count + 1;
                    q.offer(new int[]{dx, dy, dz});
                }
            }
        }
    }
}