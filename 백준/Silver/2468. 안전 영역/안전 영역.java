import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static final int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    private static int[][] map;
    private static int[][] copiedMap;
    private static int n;

    private static void copy(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = copiedMap[i][j];
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        copiedMap = new int[n][n];

        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");

            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(input[j]);
                copiedMap[i][j] = map[i][j];
            }
        }

        // n - 1 이하인 지점들은 모두 물에 잠긴다
        // 안전한 영역은 위, 아래, 오른쪽, 왼쪽에 물에 잠기지 않는 지역들이 있어야 함
        // dfs

        int answer = 0;

        for(int i=1; i<=100; i++){
            copy();
            answer = Math.max(solve(i), answer);
        }

        System.out.println(answer);
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static int solve(int height){
        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] >= height){
                    map[i][j] = -1;
                    dfs(i, j, height);
                    answer++;
                }
            }
        }

        return answer;
    }

    private static void dfs(int x, int y, int height){

        for(int[] DIRECTION : DIRECTIONS){
            int dx = x + DIRECTION[0];
            int dy = y + DIRECTION[1];

            if(!inRange(dx, dy)){
                continue;
            }

            if(map[dx][dy] >= height){
                map[dx][dy] = -1;
                dfs(dx, dy, height);
            }
        }
        
    }
}