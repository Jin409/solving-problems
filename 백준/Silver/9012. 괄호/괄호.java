import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            
            String[] input = br.readLine().split("");

            Queue<String> q = new LinkedList<>();

            boolean isValid = true;
            for(int i=0; i<input.length; i++){
                if(input[i].equals("(")){
                    q.offer(input[i]);
                }

                if(input[i].equals(")")){
                    if(q.isEmpty()){
                        isValid = false;
                        break;
                    }
                    
                    String top = q.peek();
                    if(top.equals("(")){
                        q.poll();
                    }else{
                        isValid = false;
                        break;
                    }
                }
            }

            if(!q.isEmpty()){
                isValid = false;
            }

            if(isValid){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}