import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> d = new LinkedList<>();
		for(int i=1; i<=n; i++){
			d.addLast(i);
		}

		while(d.size()>1){
			d.pollFirst();
			int top = d.pollFirst();
			d.addLast(top);
		}

		System.out.print(d.pollLast());
	}
}