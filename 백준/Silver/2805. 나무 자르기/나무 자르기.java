import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static int target;
    private static int[] trees;
    private static int answer = 0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        target = Integer.parseInt(input[1]);

        trees = new int[n];

        input = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            trees[i] = Integer.parseInt(input[i]);
        }

        find(0, 1_000_000_000);

        System.out.print(answer);
    }

    private static void find(int start, int end){
        int middle = (start + end) / 2;

        if(start > end){
            return;
        }

        long result = 0;
        for(int tree : trees){
            if(tree > middle){
                result += (tree - middle);
            }
        }
        
        if(result < target){
            find(start, middle-1);
        }else{
            answer = Math.max(answer, middle);
            find(middle+1, end);
        }
    }
}