import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int arrivalFloor;
    private static int[] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int totalFloors = Integer.parseInt(s[0]);
        map = new int[totalFloors + 1];
        visited = new boolean[totalFloors + 1];

        int now = Integer.parseInt(s[1]);
        arrivalFloor = Integer.parseInt(s[2]);
        int up = Integer.parseInt(s[3]);
        int down = Integer.parseInt(s[4]);

        if (now == arrivalFloor) {
            System.out.println(0);
            return;
        }

        if ((now > arrivalFloor && down == 0) || (now < arrivalFloor && up == 0)) {
            System.out.println("use the stairs");
            return;
        }

        if (up >= totalFloors || down >= totalFloors) {
            System.out.println("use the stairs");
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        map[now] = 0;
        visited[now] = true;

        while (!q.isEmpty()) {
            Integer top = q.poll();

            if (top + up <= totalFloors && !visited[top + up]) {
                map[top + up] = map[top] + 1;
                visited[top + up] = true;
                q.add(top + up);
            }

            if (top - down >= 1 && !visited[top - down]) {
                map[top - down] = map[top] + 1;
                visited[top - down] = true;
                q.add(top - down);
            }

        }

        if(map[arrivalFloor] == 0){
            System.out.println("use the stairs");
            return;
        }
        System.out.println(map[arrivalFloor]);
    }
}
