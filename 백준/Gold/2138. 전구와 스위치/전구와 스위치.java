import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static boolean[] asIs;
    static boolean[] toBe;

    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        asIs = new boolean[n];
        toBe = new boolean[n];

        String[] s = br.readLine().split("");
        for(int i=0; i<n; i++){
            if(s[i].equals("0")){
                asIs[i] = false;
            }else{
                asIs[i] = true;
            }
        }
        
        s = br.readLine().split("");
        for(int i=0; i<n; i++){
            if(s[i].equals("0")){
                toBe[i] = false;
            }else{
                toBe[i] = true;
            }
        }

        boolean[] switched = asIs.clone();
        switchLights(switched, 0);
        solve(switched, 1);
        int copiedAnswer = count;

        count = 0;
        boolean[] notSiwtched = asIs.clone();
        solve(notSiwtched, 1);

        if(!matches(switched) && !matches(notSiwtched)){
            System.out.println(-1);
            return;
        }

        if(!matches(switched) && matches(notSiwtched)){
            System.out.print(count);
            return;
        }

        if(matches(switched) && !matches(notSiwtched)){
            System.out.print(copiedAnswer);
            return;
        }

        if(matches(switched) && matches(notSiwtched)){
            System.out.print(Math.min(copiedAnswer, count));
            return;
        }
    }

    private static void solve(boolean[] lights, int index){
        if(index==lights.length){
            return;
        }
        
        if(lights[index-1] != toBe[index-1]){
            switchLights(lights, index);
            solve(lights, index+1);
        }else{
            // 같다면
            solve(lights, index+1);
        }
    }

    private static void switchLights(boolean[] lights, int i){
        int start = Math.max(i-1, 0);
        int end = Math.min(lights.length-1, i+1);
        count++;

        for(int j=start; j<=end; j++){
            lights[j] = !lights[j];
        }
    }

    private static boolean matches(boolean[] lights){
        for(int i=0; i<lights.length; i++){
            if(lights[i]!=toBe[i]){
                return false;
            }
        }
        return true;
    }
}