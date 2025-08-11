import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];

        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j){
                    continue;
                }

                if(graph[i][j] == 1){
                    int[] availableToAccess = graph[j];

                    for(int k=0; k<N; k++){
                        if(availableToAccess[k]==1){
                            graph[i][k] = 1;
                        }
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j){
                    continue;
                }

                if(graph[i][j] == 1){
                    int[] availableToAccess = graph[j];

                    for(int k=0; k<N; k++){
                        if(availableToAccess[k]==1){
                            graph[i][k] = 1;
                        }
                    }
                }
            }
        }

         for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j] == 1){
                    System.out.print(1+" ");
                }else{
                     System.out.print(0+" ");
                }
            }
            System.out.println();
        }

    }

}