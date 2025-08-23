import java.util.*;
import java.io.*;

public class Main {

private static int A_COUNT;
private static int C_COUNT;
private static int G_COUNT;
private static int T_COUNT;

private static int RESULT = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int length = Integer.parseInt(s[0]);
		int passwordLength = Integer.parseInt(s[1]);

		String input = br.readLine();

		s = br.readLine().split(" ");
		A_COUNT = Integer.parseInt(s[0]);
		C_COUNT = Integer.parseInt(s[1]);
		G_COUNT = Integer.parseInt(s[2]);
		T_COUNT = Integer.parseInt(s[3]);

		int[] comparedCount = {
			A_COUNT,
			C_COUNT,
			G_COUNT,
			T_COUNT
		};

		int startIndex = 0;
		int endIndex = startIndex + (passwordLength-1);
		String newInput = input.substring(startIndex, endIndex+1);
		int[] count = getCount(newInput);
		checkForPassword(count, comparedCount);

		while(endIndex < length){
			if(input.charAt(startIndex)=='A'){
				count[0]--;
			}
			if(input.charAt(startIndex)=='C'){
				count[1]--;
			}
			if(input.charAt(startIndex)=='G'){
				count[2]--;
			}
			if(input.charAt(startIndex)=='T'){
				count[3]--;
			}

			startIndex++;
			endIndex++;

			if(endIndex >= length){
				break;
			}

			if(input.charAt(endIndex)=='A'){
				count[0]++;
			}
			if(input.charAt(endIndex)=='C'){
				count[1]++;
			}
			if(input.charAt(endIndex)=='G'){
				count[2]++;
			}
			if(input.charAt(endIndex)=='T'){
				count[3]++;
			}

			checkForPassword(count, comparedCount);
		}

		System.out.println(RESULT);
	}

	private static void checkForPassword(int[] count, int[] comparedCount){
		for(int i=0; i<4; i++){
			if(count[i]<comparedCount[i]){
				return;
			}
		}
		RESULT++;
	}

	private static int[] getCount(String s){
		int[] count = new int[4];

		for(char c : s.toCharArray()){
			if(c=='A'){
				count[0]++;
			}
			if(c=='C'){
				count[1]++;
			}
			if(c=='G'){
				count[2]++;
			}
			if(c=='T'){
				count[3]++;
			}
		}

		return count;
	}
}