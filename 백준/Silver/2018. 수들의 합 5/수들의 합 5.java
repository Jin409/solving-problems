import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int sum = 1;
		int count = 0;
		int startIndex = 1;
		int endIndex = 1;

		while(true){
			if(startIndex > N){
				System.out.print(count);
				return;
			}

			if(sum < N){
				endIndex++;
				sum += endIndex;
			}

			if(sum > N){
				sum -= startIndex;
				startIndex++;
			}

			if(sum == N){
				endIndex++;
				sum += endIndex;
				count++;
			}
		}
	}
}