

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[size + 1];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (nodes[value - 'A'] == null) {
                nodes[value - 'A'] = new Node(value);
            }

            // 왼쪽이 존재하는 경우
            if (left != '.') {
                nodes[left - 'A'] = new Node(left);
                nodes[value - 'A'].left = nodes[left - 'A'];
            }

            if (right != '.') {
                nodes[right - 'A'] = new Node(right);
                nodes[value - 'A'].right = nodes[right - 'A'];
            }
        }

        pre(nodes[0]);
        System.out.println();
        in(nodes[0]);
        System.out.println();
        post(nodes[0]);
    }

    public static void pre(Node node) {
        System.out.print(node.value);
        if (node.left != null) {
            pre(node.left);
        }
        if (node.right != null) {
            pre(node.right);
        }
    }

    public static void in(Node node) {
        if (node.left != null) {
            in(node.left);
        }
        System.out.print(node.value);
        if (node.right != null) {
            in(node.right);
        }
    }

    public static void post(Node node) {
        if (node.left != null) {
            post(node.left);
        }
        if (node.right != null) {
            post(node.right);
        }
        System.out.print(node.value);
    }


    private static class Node {
        private char value;
        private Node left;
        private Node right;

        public Node(char value) {
            this.value = value;
        }
    }
}
