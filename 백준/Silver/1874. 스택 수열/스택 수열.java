import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());


		int[] targets = new int[n];

		for(int i=0; i<n; i++){
			int target = Integer.parseInt(br.readLine());
			targets[i] = target;
		}

		List<String> answer = new ArrayList<>();

		Stack<Integer> s = new Stack<>();
		int index = 0;

		for(int target : targets){
			if(s.isEmpty()){
				index++;
				s.add(index);
				answer.add("+");
			}

			if(!s.isEmpty() && target == s.peek()){
				s.pop();
				answer.add("-");
				continue;
			}

			if(index == target){
				s.add(index);
				answer.add("+");
				s.pop();
				answer.add("-");
			}

			if(target > index){
				int count = target-index;
				for(int i=0; i<count; i++){
					index++;
					s.add(index);
					answer.add("+");
				}
				s.pop();
				answer.add("-");
			}

			if(target < index){
				if(s.isEmpty() || s.peek() != target){
					System.out.println("NO");
					return;
				}
				while(target!=s.peek()){
					s.pop();
					answer.add("-");
				}
				s.pop();
				answer.add("-");
			}
		}

		for(String ans : answer){
			System.out.println(ans);
		}
	}
}