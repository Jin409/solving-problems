import java.io.*;
import java.util.*;

public class Main {

	private static int COUNT = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		List<List<Integer>> people = new ArrayList<>();
		for(int i=0; i<n; i++){
			people.add(new ArrayList<>());
		}

		boolean[] visited = new boolean[n];
		int[] count = new int[n];

		for(int i=0; i<m; i++){
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			people.get(a).add(b);
			people.get(b).add(a);
		}

		for(int i=0; i<n; i++){
			if(visited[i]){
				continue;
			}

			count[i] = 1;
			visited[i] = true;
			solve(i, people, visited, count);

			if(COUNT>=5){
				System.out.println(1);
				return;
			}

			visited = new boolean[n];
			count = new int[n];
		}

		System.out.println(0);
	}

	private static void solve(int index, List<List<Integer>> people, boolean[] visited, int[] count){
		if(COUNT >= 5){
			return;
		}

		visited[index] = true;

		for(int i=0; i<people.get(index).size(); i++){
			int friend = people.get(index).get(i);

			if(!visited[friend]){
				count[friend] = count[index]+1;
				COUNT = Math.max(COUNT, count[friend]);
				visited[friend] = true;
				solve(friend, people, visited, count);
				visited[friend] = false;
			}
		}
	}
}