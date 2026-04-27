import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static List<Integer> numbers;
    private static boolean[] answers;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        numbers = new ArrayList<>();
        for(int i=0; i<n; i++){
            numbers.add(Integer.parseInt(input[i]));
        }
        Collections.sort(numbers);

        int m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        answers = new boolean[m];
        for(int i=0; i<m; i++){
            find(0, n-1, i, Integer.parseInt(input[i]));
        }

        for(int i=0; i<m; i++){
            if(answers[i]){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    private static void find(int start, int end, int index, int comparedNumber){
        int middle = (start + end) / 2;

        if(start > end){
            answers[index] = false;
            return;
        }

        if(numbers.get(middle) == comparedNumber){
            answers[index] = true;
            return;
        }

        if(numbers.get(middle) < comparedNumber){
            find(middle+1, end, index, comparedNumber);
        }else{
            find(start, middle-1, index, comparedNumber);
        }
    }
}