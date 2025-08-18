import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] ingredients = new int[N];

		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++){
			ingredients[i] = Integer.parseInt(s[i]);
		}

		int count = 0;

		for(int i=0; i<N; i++){
			int sum = ingredients[i];
			for(int j=i+1; j<N; j++){
				if(sum+ingredients[j]==M){
					count++;
				}
			}
		}

		System.out.print(count);
	}

}