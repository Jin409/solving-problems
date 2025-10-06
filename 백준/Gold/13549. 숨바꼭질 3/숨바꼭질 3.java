import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    private static int[] times;
    private static int n;
    private static int k;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        times = new int[100_001];
        Arrays.fill(times, Integer.MAX_VALUE);

        times[n] = 0;
        solve();

        System.out.print(times[k]);
    }

    private static void solve(){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty()){
            int top = q.poll();
            int time = times[top];

            if(top*2<times.length && times[top*2]==Integer.MAX_VALUE){
                q.add(top*2);
                times[top*2] = time;
            }
            if(top-1>=0 && times[top-1]==Integer.MAX_VALUE){
                q.add(top-1);
                times[top-1] = time+1;
            }
            if(top+1<times.length && times[top+1]==Integer.MAX_VALUE){
                q.add(top+1);
                times[top+1] = time+1;
            }
        }
    }
}