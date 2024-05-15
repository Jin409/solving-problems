
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] numbers;
    static int answer;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        while (T > 0) {
            T--;
            size = Integer.parseInt(br.readLine());
            answer = 0;
            numbers = new int[size + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= size; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= size; i++) {
                if (numbers[i] != 0) {
                    dfs(i);
                }
            }

            System.out.println(answer);
        }
    }

    // 종료 조건 1. 모든 순열을 다 돌았을 때 2. 사이클을 찾았을 때
    public static void dfs(int index) {
        int number = numbers[index];
        numbers[index] = 0; // 방문했다는 표식

        if (number <= size && numbers[number] == 0) {
            answer++;
        } else if (number <= size && numbers[number] != 0) {
            dfs(number);
        }
    }
}
