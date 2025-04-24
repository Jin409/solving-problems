import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            String[] s = input.split(" ");

            int size = Integer.parseInt(s[0]);
            int[] numbers = new int[size];

            for (int i = 1; i <= size; i++) {
                numbers[i - 1] = Integer.parseInt(s[i]);
            }

            List<List<Integer>> total = new ArrayList<>();
            add(numbers, 0, new ArrayList<>(), total);

            total.sort((a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            });

            for (List<Integer> result : total) {
                for (int i = 0; i < result.size(); i++) {
                    System.out.print(result.get(i) + " ");
                }
                System.out.println();
            }

            System.out.println();
        }
    }

    private static void add(int[] numbers, int index, List<Integer> result, List<List<Integer>> total) {
        if (index == numbers.length) {
            if (result.size() == 6) {
                ArrayList<Integer> copiedTotal = new ArrayList<>(result);
                copiedTotal.sort(Integer::compareTo);
                total.add(copiedTotal);
            }
            return;
        }

        add(numbers, index + 1, new ArrayList<>(result), total);

        ArrayList<Integer> copiedList = new ArrayList<>(result);
        copiedList.add(numbers[index]);
        add(numbers, index + 1, copiedList, total);
    }
}
