import java.util.*;
import java.io.*;

public class Main {

	private static int[] NUMBERS;
	private static int[] SORTED;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);

		s = br.readLine().split(" ");
		NUMBERS = new int[N];
		SORTED = new int[N];

		for(int i=0; i<N; i++){
			NUMBERS[i] = Integer.parseInt(s[i]);
		}

		solve(0, N-1);
		System.out.println(NUMBERS[k-1]);
	}

	private static void reArrange(int start, int end){
		int middle = (start+end)/2;
		int left = start;
		int right = middle+1;
		int index = left;

		while(left <= middle && right <= end){
			if(NUMBERS[left] <= NUMBERS[right]){
				SORTED[index] = NUMBERS[left];
				left++;
			}else{
				SORTED[index] = NUMBERS[right];
				right++;
			}

			index++;
		}

		while(left <= middle){
			SORTED[index] = NUMBERS[left];
			left++;
			index++;
		}

		while(right <= end){
			SORTED[index] = NUMBERS[right];
			index++;
			right++;
		}

		for(int i=start; i<=end; i++){
			NUMBERS[i] = SORTED[i];
		}
	}

	private static void solve(int start, int end){
		if(start >= end){
			return;
		}

		int middle = (start+end)/2;

		solve(start, middle);
		solve(middle+1, end);
		reArrange(start, end);
	}
}