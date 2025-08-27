import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split("");
		int n = s.length;

		int[] numbers = new int[n];
		for(int i=0; i<n; i++){
			numbers[i] = Integer.parseInt(s[i]);
		}

		for(int i=0; i<n; i++){
			int maxIndex = i;
			for(int j=i+1; j<n; j++){
				if(numbers[maxIndex] < numbers[j]){
					maxIndex = j;
				}
			}
			// swap
			int temp = numbers[maxIndex];
			numbers[maxIndex] = numbers[i];
			numbers[i] = temp;
		}

		for(int i=0; i<n; i++){
			System.out.print(numbers[i]);
		}
	}
}