import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
private static int N;
private static int M;
private static int[][] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        numbers = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            s = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                numbers[i][j] = numbers[i][j-1] + (Integer.parseInt(s[j-1]));
            }
        }


        for(int i=1; i<=M; i++){
            s = br.readLine().split(" ");

            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);

            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            System.out.println(calculate(x1, y1, x2, y2));
        }
    }

    private static int calculate(int x1, int y1, int x2, int y2){
        int result = 0;

        for(int i=x1; i<=x2; i++){
            if(y1==0){
                result += numbers[i][y2];
                continue;
            }

            result += (numbers[i][y2] - numbers[i][y1-1]);
        }

        return result;
    }
}