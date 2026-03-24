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
    private static int[][] staticMap;

    private static int n;
    private static int m;

    private static boolean isSeperated(){
        int callCount = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] != 0 && staticMap[i][j] != 0){
                    callCount++;
                    dfs(i, j);
                }
            }
        }

        return callCount > 1; // 2번 이상 부름 == 분리 안됨
    }

    private static void copy(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                staticMap[i][j] = map[i][j];
            }
        }
    }

    private static boolean isTimeToEnd(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(staticMap[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        staticMap = new int[n][m];

        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");

            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
                staticMap[i][j] = map[i][j];
            }
        }

        int answer = 0;
        while(!isTimeToEnd()){
            answer++;
            change(); // 1년 뒤

            if(isSeperated()){
                System.out.println(answer);
                return;
            }
            
            copy();
        }

        System.out.print(0);
    }

    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }

    private static int count(int x, int y){
        int count = 0;
        
        for(int[] DIRECTION : DIRECTIONS){
            int dx = x + DIRECTION[0];
            int dy = y + DIRECTION[1];

            if(!inRange(dx, dy)){
                continue;
            }

            if(staticMap[dx][dy] == 0){
                count++;
            }
        }

        return count;
    }

    private static void change(){ // 1년 뒤 감소하는 모습 계산
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(staticMap[i][j] != 0){
                    int count = count(i, j); // 몇개를 감소시켜야 하는지?
                    map[i][j] = Math.max(0, staticMap[i][j] - count);
                }
            }
        }

    }

    private static void dfs(int x, int y){
        for(int[] DIRECTION : DIRECTIONS){
            int dx = x + DIRECTION[0];
            int dy = y + DIRECTION[1];

            if(!inRange(dx, dy) || map[dx][dy] == 0 || staticMap[dx][dy] == 0){
                continue;
            }

            staticMap[dx][dy] = 0;
            dfs(dx, dy);
        }
    }
}