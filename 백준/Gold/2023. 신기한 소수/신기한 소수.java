import java.io.*;

public class Main {

	private static int[] START = {2,3,5,7};
	private static int[] END = {1,3,5,7,9};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 자릿수

		StringBuffer sb = new StringBuffer();
		for(int start : START){
			solve(n, start, 1, sb);
		}

		System.out.print(sb);
	}

	private static void solve(int n, int number, int length, StringBuffer sb){
		if(!isPrime(number)){
			return;
		}

		if(length==n){
			sb.append(number+"\n");
			return;
		}

		for(int end : END){
			int newNumber = number*10+end;
			solve(n, newNumber, length+1, sb);
		}
	}

	private static boolean isPrime(int number){
		if(number <=1){
			return false;
		}
		for(int i=2; i<number; i++){
			if(number%i==0){
				return false;
			}
		}
		return true;
	}
}