import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0 && heap.size() == 0) {
                System.out.println(0);
                continue;
            }
            if (input == 0) {
                Integer minValue = heap.poll();
                System.out.println(minValue);
                continue;
            } else {
                heap.add(input);
            }
        }
    }
}
