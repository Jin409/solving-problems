import java.io.*;
import java.util.*;

public class Main {

	private static int v;
	private static List<List<Integer>> map;
	private static int[] count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		v = Integer.parseInt(br.readLine());
		map = new ArrayList<>();
		count = new int[v+1];

		for(int i=0; i<=v; i++){
			map.add(new ArrayList<>());
		}

		for(int i=1; i<=v; i++){
			String[] s = br.readLine().split(" ");
			int point = Integer.parseInt(s[0]);
			for(int j=1; j<s.length-2; j+=2){
				int connectedPoint = Integer.parseInt(s[j]);
				int distance = Integer.parseInt(s[j+1]);

				map.get(point).add(connectedPoint);
				map.get(point).add(distance);
			}
		}

		// 가장 먼 지점 찾기
		dfs(1);
		int farAwayPoint = findMaxIndex();
		Arrays.fill(count, 0);

		// 가장 먼 지점에게도 먼 지점 찾기
		dfs(farAwayPoint);
		int farAwayPointOfPoint = findMaxIndex();
		System.out.print(count[farAwayPointOfPoint]);
	}

	private static void dfs(int index){
		Queue<Integer> q = new LinkedList<>();
		q.add(index);

		while(!q.isEmpty()){
			int top = q.poll();

			List<Integer> connectedPoints = map.get(top);
			for(int i=0; i<connectedPoints.size()-1; i+=2){
				int point = connectedPoints.get(i);
				int distance = connectedPoints.get(i+1);

				// 시작 지점과 같으면 지나치기
				if(point == index){
					continue;
				}

				// 이미 방문한 곳이면 지나치기
				if(count[point] > 0){
					continue;
				}

				count[point] = count[top] + distance;
				q.add(point);
			}
		}
	}

	private static int findMaxIndex(){
		int result = 0;
		int index = 0;

		for(int i=1; i<count.length; i++){
			if(result < count[i]){
				index = i;
				result = count[i];
			}
		}

		return index;
	}
}