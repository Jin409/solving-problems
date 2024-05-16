import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> nums = new ArrayList<>();
    static int p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        // 각 자리수 구하기 -> 10000부터 나눠서 몫 구하기
        solve(a);
    }

    public static int[] findNums(int num) {
        int lengthOfNumber = String.valueOf(num).length();
        int[] numberOfUnits = new int[lengthOfNumber];
        double divider = Math.pow(10, lengthOfNumber - 1);
        for (int i = lengthOfNumber - 1; i >= 0; i--) {
            numberOfUnits[i] = (int) (num / divider);
            num = (int) (num % divider);
            divider /= 10;
        }

        return numberOfUnits;
    }

    public static void solve(int num) {
        if (!nums.contains(num)) {
            nums.add(num);
            int[] numberOfUnits = findNums(num);
            int newNum = 0;
            // 각 자릿수를 제곱수
            for (int i = 0; i < numberOfUnits.length; i++) {
                newNum += (int) Math.pow(numberOfUnits[i], p);
            }
            solve(newNum);
        } else {
            System.out.println(nums.indexOf(num));
        }
    }
}
