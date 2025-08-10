import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String CONDITION = "666";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int number = 1;
        int count = 0;

        while(true){

            if(String.valueOf(number).contains(CONDITION)){
                count++;
            }

            if(count == n){
                System.out.print(number);
                break;
            }

            number++;
        }

    }
}