import java.util.*;
import java.io.*;

public class Main {

	private static final int POLL_OUT_SIGN = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>((input1, input2)->{
			if(Math.abs(input1)==Math.abs(input2)){
				return input1 - input2;
			}
			return Math.abs(input1) - Math.abs(input2);
		});

		for(int i=0; i<n; i++){
			int input = Integer.parseInt(br.readLine());

			if(input == POLL_OUT_SIGN && minHeap.size()==0){
				System.out.println(0);
				continue;
			}

			if(input == POLL_OUT_SIGN){
				int top = minHeap.poll();
				System.out.println(top);
				continue;
			}
			minHeap.add(input);
		}
	}
}