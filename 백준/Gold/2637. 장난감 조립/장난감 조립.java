import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class Node{
        public final int toBe;
        public final int k; // 카운트

        Node(int toBe, int k) { this.toBe = toBe; this.k = k; }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 완제품
        int m = Integer.parseInt(br.readLine());
        
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        int[] indexes = new int[n+1];
        int[][] needs = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            String[] s = br.readLine().split(" ");

            int target = Integer.parseInt(s[0]);
            int supply = Integer.parseInt(s[1]);
            int count = Integer.parseInt(s[2]);

            graph.get(supply).add(new Node(target, count));
            indexes[target]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){

            // 기본
            if(indexes[i]==0){
                q.offer(i);
                needs[i][i] = 1;
            }
        }

        while(!q.isEmpty()){
            int top = q.poll();

            for(Node node : graph.get(top)){
                for(int i=1; i<=n; i++){
                    if(needs[top][i]==0){
                        continue;
                    }

                    needs[node.toBe][i] += (needs[top][i] * node.k);
                }

                indexes[node.toBe]--;
                if(indexes[node.toBe]==0){
                    q.offer(node.toBe);
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(needs[n][i] > 0){
                System.out.println(i+" "+needs[n][i]);
            }
        }
    }
}