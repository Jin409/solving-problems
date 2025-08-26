import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] numbers = new int[n];
		String[] s = br.readLine().split(" ");

		for(int i=0; i<n; i++){
			numbers[i] = Integer.parseInt(s[i]);
		}

		Stack<Integer> stack = new Stack<>();
		stack.add(0);

		int[] answers = new int[n];

		for(int i=1; i<n; i++){
			while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
				int top = stack.peek();
				if(numbers[i] > numbers[top]){
					stack.pop();
					answers[top] = numbers[i];
				}
				if(numbers[i] < numbers[top]){
					break;
				}
			}
			stack.add(i);
		}

		while(!stack.isEmpty()){
			int index = stack.pop();
			answers[index] = -1;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int ans : answers){
			bw.write(ans+" ");
		}
		bw.write("\n");
		bw.flush();
	}
}