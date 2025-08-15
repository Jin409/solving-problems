import java.io.*;
import java.util.*;

public class Main {

    private static final int ROOT_INDEX = 0;
    private static final int LEFT_INDEX = 1;
    private static final int RIGHT_INDEX = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] tree = new char[n][3];

        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");

            char root = s[ROOT_INDEX].toCharArray()[0];
            int rootIndex = root-'A';

            tree[rootIndex][ROOT_INDEX] = root;

            char left = s[LEFT_INDEX].toCharArray()[0];
            tree[rootIndex][LEFT_INDEX] = left;

            char right = s[RIGHT_INDEX].toCharArray()[0];
            tree[rootIndex][RIGHT_INDEX] = right;
        }

        StringBuffer sb = new StringBuffer();
        rootAtFirst(tree, 0, sb);
        System.out.println(sb);

        sb.setLength(0);

        rootInMiddle(tree, 0, sb);
        System.out.println(sb);

        sb.setLength(0);

        rootAtLast(tree, 0, sb);
        System.out.println(sb);
    }

    private static void rootAtFirst(char[][] tree, int index, StringBuffer sb){
        sb.append(tree[index][ROOT_INDEX]);

        if(tree[index][LEFT_INDEX]!='.'){
            rootAtFirst(tree, tree[index][LEFT_INDEX]-'A', sb);
        }

        if(tree[index][RIGHT_INDEX]!='.'){
            rootAtFirst(tree, tree[index][RIGHT_INDEX]-'A', sb);
        }
    }

    private static void rootInMiddle(char[][] tree, int index, StringBuffer sb){
        if(tree[index][LEFT_INDEX]!='.'){
            rootInMiddle(tree, tree[index][LEFT_INDEX]-'A', sb);
        }

        sb.append(tree[index][ROOT_INDEX]);

        if(tree[index][RIGHT_INDEX]!='.'){
            rootInMiddle(tree, tree[index][RIGHT_INDEX]-'A', sb);
        }
    }

    private static void rootAtLast(char[][] tree, int index, StringBuffer sb){
        if(tree[index][LEFT_INDEX]!='.'){
            rootAtLast(tree, tree[index][LEFT_INDEX]-'A', sb);
        }

        if(tree[index][RIGHT_INDEX]!='.'){
            rootAtLast(tree, tree[index][RIGHT_INDEX]-'A', sb);
        }

        sb.append(tree[index][ROOT_INDEX]);
    }
}