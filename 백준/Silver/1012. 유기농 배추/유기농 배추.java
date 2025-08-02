import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

public class Main {

    private static int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0,-1},
    };

    private static int maxX;
    private static int maxY;

    private static int[][] lettuceIndexes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- >0){
            String[] s = br.readLine().split(" ");
            maxY = Integer.parseInt(s[0]); // y
            maxX = Integer.parseInt(s[1]); // x
            int lettuceCount = Integer.parseInt(s[2]);

            lettuceIndexes  = new int[maxX][maxY];

            for(int i=0; i<lettuceCount; i++){
                s = br.readLine().split(" ");
                int y = Integer.parseInt(s[0]);
                int x = Integer.parseInt(s[1]);

                lettuceIndexes[x][y] = 1;
            }

            int answer = 0;

            for(int i=0; i<maxX; i++){
                for(int j=0; j<maxY; j++){
                    if(lettuceIndexes[i][j]==1){
                        lettuceIndexes[i][j] = 0;
                        move(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    private static boolean isInRange(int x, int y){
        return x>=0 && x < maxX && y >=0 && y<maxY;
    }

    private static void move(int x, int y){
        Stack<List<Integer>> s = new Stack<>();
        s.push(List.of(x,y));

        while(!s.isEmpty()){
            List<Integer> top = s.pop();
            int topX = top.get(0);
            int topY = top.get(1);

            for(int[] direction : DIRECTIONS){
            int dx =topX+ direction[0];
            int dy = topY+direction[1];

            if(isInRange(dx,dy) && lettuceIndexes[dx][dy] == 1){
                lettuceIndexes[dx][dy] = 0;
                s.add(List.of(dx,dy));
            }
        }
        }

    }
}
