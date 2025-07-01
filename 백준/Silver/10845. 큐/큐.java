import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] orders = new String[n];
        for (int i = 0; i < n; i++) {
            orders[i] = br.readLine();
        }

        Deque<String> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (orders[i].contains("push")) {
                q.add(orders[i].split(" ")[1]);
            }
            if (orders[i].contains("front")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(q.peek());
            }
            if (orders[i].contains("back")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(q.getLast());
            }
            if (orders[i].contains("size")) {
                System.out.println(q.size());
            }
            if (orders[i].contains("pop")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(q.poll());
            }
            if (orders[i].contains("empty")) {
                if (q.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println(0);
                }
            }
        }

    }
}
