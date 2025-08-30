import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		int[][] graph = new int[n+1][n+1];
		boolean[] visited = new boolean[n+1];

		for(int i=0; i<m; i++){
			s = br.readLine().split(" ");

			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		Stack<Integer> stack = new Stack<>();
		int result = 0;
		for(int i=1; i<=n; i++){
			if(visited[i]==true){
				continue;
			}
			stack.push(i);
			solve(stack, visited, n, graph);
			result++;
		}

		System.out.println(result);
	}

	private static void solve(Stack<Integer> stack, boolean[] visited, int n, int[][] graph){
		while(!stack.isEmpty()){
			int top = stack.pop();

			for(int i=0; i<=n; i++){
				if(visited[i] == true){
					continue;
				}
				if(graph[top][i] == 0){
					continue;
				}
				stack.push(i);
				visited[i] = true;
			}
		}
	}
}