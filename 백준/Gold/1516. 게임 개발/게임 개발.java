import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        int[] indexes = new int[n+1];
        int[] times = new int[n+1];
        int[] results = new int[n+1];
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");

            int building = i+1; // 건물 번호
            int time = Integer.parseInt(s[0]); // 건물을 짓는 데에 걸리는 시간
            times[building] = time;

            for(int j=1; j<s.length-1; j++){
                int a = Integer.parseInt(s[j]); // 이 건물 짓기 위해 지어져야 하는 건물
                graph.get(a).add(building);
                indexes[building]++; // 위상 정렬 위한 진입 차수 저장
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indexes[i]==0){
                q.offer(i);
                results[i] = times[i];
            }
        }

        while(!q.isEmpty()){
            int top = q.poll();

            // top 을 필요로 하는 건물들
            for(int point : graph.get(top)){
                results[point] = Math.max(results[point], results[top] + times[point]);
                
                indexes[point]--;
                if(indexes[point]==0){
                    q.offer(point);
                }
            }
        }

        for(int i=1; i<=n; i++){
            System.out.println(results[i]);
        }
    }
}