import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static final Map<Integer, List<int[]>> DIRECTIONS = Map.of(
        0, List.of(new int[]{-1, 0}, new int[]{1, 0}), // 북
        1, List.of(new int[]{0, 1}, new int[]{0, -1}), // 동
        2, List.of(new int[]{1, 0}, new int[]{-1, 0}), // 남
        3, List.of(new int[]{0, -1}, new int[]{0, 1})  // 서
    );

    private static final int[][] MOVE_DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    private static int rotate(int now){
        return (now -1 + 4) % 4;
    }

    private static int[][] map;

    private static int n;
    private static int m;
    private static int answer;

    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];

        input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int direction = Integer.parseInt(input[2]);

        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(x, y, direction);
        System.out.println(answer);
    }

    private static boolean isDirty(int x, int y){
        for(int[] MOVE_DIRECTION : MOVE_DIRECTIONS){
            int dx = x + MOVE_DIRECTION[0];
            int dy = y + MOVE_DIRECTION[1];

            if(inRange(dx, dy) && map[dx][dy] == 0){
                return true;
            }
        }
        return false;
    }

    private static void dfs(int x, int y, int direction){
        
        if(map[x][y] == 0){ // 청소가 안된 경우
            map[x][y] = -1;
            answer++;
        }

        if(isDirty(x, y)){
            for(int i=0; i<4; i++){
                direction = rotate(direction);
    
                int dx = x + DIRECTIONS.get(direction).get(0)[0];
                int dy = y + DIRECTIONS.get(direction).get(0)[1];
    
                if(inRange(dx, dy) && map[dx][dy] == 0){
                    dfs(dx, dy, direction);
                    break;
                }
            }
        }else{
            int dx = x + DIRECTIONS.get(direction).get(1)[0];
            int dy = y + DIRECTIONS.get(direction).get(1)[1];

            if(inRange(dx, dy) && map[dx][dy] == -1){
                dfs(dx, dy, direction);
            }
        }
    }
}