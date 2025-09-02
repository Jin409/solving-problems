import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int v = Integer.parseInt(s[2]);

		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<>());
		}

		boolean[] visited = new boolean[n+1];

		for(int i=0; i<m; i++){
			s = br.readLine().split(" ");

			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for(int i=1; i<=n; i++){
			Collections.sort(graph.get(i));
		}

		StringBuffer sb = new StringBuffer();
		visited[v] = true;
		dfs(graph, v, visited, sb);
		System.out.println(sb);

		sb = new StringBuffer();
		visited = new boolean[n+1];
		visited[v] = true;
		bfs(graph, v, visited, sb);
		System.out.println(sb);
	}

	public static void dfs(List<List<Integer>> graph, int index, boolean[] visited, StringBuffer sb){
		sb.append(index+" ");

		for(int i=0; i<graph.get(index).size(); i++){
			int friend = graph.get(index).get(i);

			if(!visited[friend]){
				visited[friend] = true;
				dfs(graph, friend, visited, sb);
			}
		}
	}

	public static void bfs(List<List<Integer>> graph, int index, boolean[] visited, StringBuffer sb){
		Queue<Integer> q = new LinkedList<>();
		q.add(index);

		while(!q.isEmpty()){
			int top = q.poll();
			sb.append(top+" ");

			for(int i=0; i<graph.get(top).size(); i++){
				int friend = graph.get(top).get(i);
				if(!visited[friend]){
					q.add(friend);
					visited[friend] = true;
				}
			}
		}
	}
}