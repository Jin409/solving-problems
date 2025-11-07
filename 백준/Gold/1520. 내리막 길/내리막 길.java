import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static final int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    
    static int answer = 0;

    static int m; // 세로 -> x
    static int n; // 가로 -> y
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        m = Integer.parseInt(s[0]); // 세로
        n = Integer.parseInt(s[1]); // 가로

        int[][] map = new int[m][n];

        for(int i=0; i<m; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 초기화
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        System.out.println(solve(0, 0, map, dp));
    }

    private static boolean isInRange(int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }

    private static int solve(int x, int y, int[][] map, int[][] dp){
        if(x == (m-1) && y == (n-1)){
            return 1;
        }
        
        if(dp[x][y] != -1){
            // 이미 캐시되어 있는 경우
            return dp[x][y];
        }

        dp[x][y] = 0;
        int now = map[x][y];

        for(int[] direction : DIRECTIONS){
            int dx = x + direction[0];
            int dy = y + direction[1];

            if(isInRange(dx, dy) && map[dx][dy] < now){
                dp[x][y] += solve(dx, dy, map, dp);
            }
        }

        return dp[x][y];
    }
}