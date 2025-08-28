import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");

		int[] numbers = new int[n];
		for(int i=0; i<n; i++){
			numbers[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(numbers);

		for(int i=1; i<n; i++){
			numbers[i] = numbers[i-1]+numbers[i];
		}

		int result = 0;
		for(int i=0; i<n; i++){
			result += numbers[i];
		}
		System.out.println(result);
	}
}