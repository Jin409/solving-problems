import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
 
		int[] counting = new int[10];
 
		int n = Integer.parseInt(scanner.nextLine());
 
		while (n != 0) {
			counting[n % 10]++;
			n /= 10;
		}
 
		for (int i = 9; i >= 0; i--) {
			while (counting[i]-- > 0) {
				System.out.print(i);
			}
		}
 
	}
}