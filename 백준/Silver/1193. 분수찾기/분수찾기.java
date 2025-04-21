import java.util.Scanner;

public class Main {
    public static int findGroup(int target) {
        int sum = 0;
        int group = 0;

        while (sum < target) {
            group++;
            sum += group;
        }

        return group;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int group = findGroup(n);
        int start = (group - 1) * group / 2 + 1;
        int end = group * (group + 1) / 2;

        // 짝수면 분자가 오름차순 & 분모는 내림차순
        if (group % 2 == 0) {
            int high = 1 + (n - start);
            int low = group - (n - start);

            System.out.println(high + "/" + low);
            return;
        }

        // 홀수면 분자가 내림차순 & 분모는 오름차순
        int high = group - (n - start);
        int low = 1 + (n - start);
        System.out.println(high + "/" + low);
    }
}
