import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        while (deque.size() > 1) {
            Integer top = deque.removeFirst();
            System.out.print(top + " ");

            Integer secondTop = deque.removeFirst();
            deque.add(secondTop);
        }

        Integer top = deque.removeFirst();
        System.out.print(top);
    }
}
