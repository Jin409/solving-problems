package 팰린드롬;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        // 두 단어를 합쳐서 팰린드롬으로 만들어야 함

        for (int i = 0; i < test; i++) {

            int k = Integer.parseInt(br.readLine());
            String[] words = new String[k];
            boolean flag = false;

            for (int j = 0; j < k; j++) {
                words[j] = br.readLine();
            }

            for (int j = 0; j < k; j++) {
                for (int w = 0; w < k; w++) {
                    if (w == j) {
                        continue;
                    }
                    String newWord = words[j] + words[w];
                    if (isPalindrome(newWord)) {
                        flag = true;
                        System.out.println(newWord);
                        break;
                    }
                }

                if (flag) {
                    break;
                }
            }

            if (flag == false) {
                System.out.println(0);
            }
        }
    }

    private static boolean isPalindrome(final String word) {
        int start = 0;
        int end = word.length() - 1;
        char[] chars = word.toCharArray();

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}