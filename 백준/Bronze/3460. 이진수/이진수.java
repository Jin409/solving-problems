import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int T = Integer.parseInt(input);

        while (T-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());

            List<Integer> nums = new ArrayList<>();
            while (n >= 1) {
                nums.add(n % 2);
                n = n / 2;
            }

            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == 1) {
                    System.out.println(i);
                }
            }
        }
    }
}
