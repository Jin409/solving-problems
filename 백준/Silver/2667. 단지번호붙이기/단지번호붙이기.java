import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    private static int[][] map;
    private static int answer = 0;
    private static List<Integer> answers = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("");

            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    answer = 0;
                    dfs(i, j);
                    answers.add(answer);
                }
            }
        }

        Collections.sort(answers); 

        System.out.println(answers.size());
        for(int answer : answers){
            System.out.println(answer);
        }
    }

    private static boolean inRange(int x, int y){
        return x>=0 && y >= 0 && x < map.length && y < map[0].length;
    }

    private static void dfs(int a, int b){
        answer++;
        map[a][b] = 0;

        for(int[] DIRECTION : DIRECTIONS){
            int dx = a + DIRECTION[0];
            int dy = b + DIRECTION[1];

            if(!inRange(dx, dy)){
                continue;
            }

            if(map[dx][dy] == 0){
                continue;
            }

            dfs(dx, dy);
        }
    }
}