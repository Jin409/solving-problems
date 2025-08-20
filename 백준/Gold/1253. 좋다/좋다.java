import java.util.*;
import java.io.*;

public class Main {

private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] numbers = new long[N];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++){
			numbers[i] = Long.parseLong(s[i]);
		}

		Arrays.sort(numbers);

		for(int i=0; i<N; i++){
			isGoodNumber(i, numbers);
		}

		System.out.print(count);
	}

	private static void isGoodNumber(int targetIndex, long[] numbers){
		int startIndex = 0;
		int endIndex = numbers.length-1;
		long sum = numbers[startIndex] + numbers[endIndex];

		while(startIndex < numbers.length && endIndex >= 0){
			sum = numbers[startIndex] + numbers[endIndex];

			if(startIndex == endIndex){
				endIndex--;
				continue;
			}

			if(targetIndex == startIndex){
				startIndex++;
				continue;
			}

			if(targetIndex == endIndex){
				endIndex--;
				continue;
			}

			if(sum == numbers[targetIndex]){
				count++;
				return;
			}

			if(sum < numbers[targetIndex]){
				startIndex++;
				continue;
			}

			if(sum > numbers[targetIndex]){
				endIndex--;
			}
		}
	}
}